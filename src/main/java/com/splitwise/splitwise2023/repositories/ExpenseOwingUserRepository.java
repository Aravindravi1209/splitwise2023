package com.splitwise.splitwise2023.repositories;

import com.splitwise.splitwise2023.models.Expense;
import com.splitwise.splitwise2023.models.ExpenseOwingUser;
import com.splitwise.splitwise2023.models.ExpensePayingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseOwingUserRepository extends JpaRepository<ExpenseOwingUser, Long> {
    List<ExpenseOwingUser> findAllByExpense(Expense expense);
}
