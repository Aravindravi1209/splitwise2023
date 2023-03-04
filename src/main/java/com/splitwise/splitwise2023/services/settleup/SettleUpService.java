package com.splitwise.splitwise2023.services.settleup;

import com.splitwise.splitwise2023.exceptions.InvalidGroupException;
import com.splitwise.splitwise2023.models.Expense;
import com.splitwise.splitwise2023.models.ExpenseOwingUser;
import com.splitwise.splitwise2023.models.ExpensePayingUser;
import com.splitwise.splitwise2023.models.Group;
import com.splitwise.splitwise2023.repositories.ExpenseOwingUserRepository;
import com.splitwise.splitwise2023.repositories.ExpensePayingUserRepository;
import com.splitwise.splitwise2023.repositories.GroupRepository;
import com.splitwise.splitwise2023.services.settleup.settleUpStrategies.SettleUpTransactionsCalculatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {

    @Qualifier("MinMaxSettleUpStrategy")
    private SettleUpTransactionsCalculatorStrategy strategy;

    private GroupRepository groupRepository;
    private ExpensePayingUserRepository expensePayinguserRepository;
    private ExpenseOwingUserRepository expenseOwingUserRepository;

    @Autowired
    public SettleUpService(SettleUpTransactionsCalculatorStrategy strategy, GroupRepository groupRepository,
                           ExpensePayingUserRepository expensePayinguserRepository,
                           ExpenseOwingUserRepository expenseOwingUserRepository) {
        this.strategy = strategy;
        this.groupRepository = groupRepository;
        this.expensePayinguserRepository = expensePayinguserRepository;
        this.expenseOwingUserRepository = expenseOwingUserRepository;
    }

    public List<Transaction> settleUpUser(Long userId)
    {
        return null;
    }

    public List<Transaction> settleUpGroup(Long groupId) throws InvalidGroupException {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (!groupOptional.isPresent()) {
            throw new InvalidGroupException("No such group exists with this Id!");
        }
        Group group = groupOptional.get();
        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>();
        List<ExpenseOwingUser> expenseOwingUsers = new ArrayList<>();

        for(Expense expense : group.getExpenses())
        {
            expensePayingUsers.addAll(expensePayinguserRepository.findAllByExpense(expense));
            expenseOwingUsers.addAll(expenseOwingUserRepository.findAllByExpense(expense));
        }
        return  strategy.getTransactions(expensePayingUsers,expenseOwingUsers);
    }
}
