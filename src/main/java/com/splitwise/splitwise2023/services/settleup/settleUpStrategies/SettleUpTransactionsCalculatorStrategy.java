package com.splitwise.splitwise2023.services.settleup.settleUpStrategies;

import com.splitwise.splitwise2023.models.ExpenseOwingUser;
import com.splitwise.splitwise2023.models.ExpensePayingUser;
import com.splitwise.splitwise2023.services.settleup.Transaction;

import java.util.List;

public interface SettleUpTransactionsCalculatorStrategy {
    List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers, List<ExpenseOwingUser> expenseOwingUsers);
}
