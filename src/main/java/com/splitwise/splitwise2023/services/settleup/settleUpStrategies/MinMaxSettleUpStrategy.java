package com.splitwise.splitwise2023.services.settleup.settleUpStrategies;

import com.splitwise.splitwise2023.models.ExpenseOwingUser;
import com.splitwise.splitwise2023.models.ExpensePayingUser;
import com.splitwise.splitwise2023.models.User;
import com.splitwise.splitwise2023.services.settleup.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

@Service
@Qualifier("MinMaxSettleUpStrategy")
public class MinMaxSettleUpStrategy implements SettleUpTransactionsCalculatorStrategy{

    class Record {
        User user;
        double pendingAmount;

        Record(User user, double pendingAmount) {
            this.user = user;
            this.pendingAmount = pendingAmount;
        }
    }
    @Override
    public List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers, List<ExpenseOwingUser> expenseOwingUsers) {
        HashMap<User, Double> extraAmount = new HashMap<>();
        for(ExpensePayingUser expensePayingUser : expensePayingUsers)
        {
            extraAmount.put(expensePayingUser.getUser(),extraAmount.getOrDefault(
                    expensePayingUser.getUser(),0.0)+expensePayingUser.getAmount());
        }
        for(ExpenseOwingUser expenseOwingUser : expenseOwingUsers)
        {
            extraAmount.put(expenseOwingUser.getUser(),extraAmount.getOrDefault(
                    expenseOwingUser.getUser(),0.0)-expenseOwingUser.getAmount());
        }

        PriorityQueue<Record> minQ = new PriorityQueue<>();
        PriorityQueue<Record> maxQ = new PriorityQueue<>((a,b)->(int)(b.pendingAmount-a.pendingAmount));
        for(User user: extraAmount.keySet())
        {
            if(extraAmount.get(user)<0)
            {
                minQ.add(new Record(user,extraAmount.get(user)));
            }
            else if (extraAmount.get(user) > 0) {
                maxQ.add(new Record(user, extraAmount.get(user)));
            }
        }
        List<Transaction> transactions = new ArrayList<>();
        while(!minQ.isEmpty() && !maxQ.isEmpty())
        {
            Record currNeg = minQ.poll();
            Record currPos = maxQ.poll();
            if(currPos.pendingAmount>Math.abs(currNeg.pendingAmount))
            {
                transactions.add(new Transaction(currNeg.user,currPos.user,Math.abs(currNeg.pendingAmount)));
                minQ.add(new Record(currPos.user,currPos.pendingAmount-Math.abs(currNeg.pendingAmount)));
            }
            else
            {
                transactions.add(new Transaction(currNeg.user,currPos.user,currPos.pendingAmount));
                minQ.add(new Record(currPos.user,currNeg.pendingAmount+currPos.pendingAmount));
            }
        }
        return transactions;
    }
}
