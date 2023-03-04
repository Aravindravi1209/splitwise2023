package com.splitwise.splitwise2023.repositories;

import com.splitwise.splitwise2023.models.Expense;
import com.splitwise.splitwise2023.models.ExpensePayingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensePayingUserRepository extends JpaRepository<ExpensePayingUser, Long> {

    List<ExpensePayingUser> findAllByExpense(Expense expense);
}
