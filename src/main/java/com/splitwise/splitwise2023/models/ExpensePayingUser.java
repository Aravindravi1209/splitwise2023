package com.splitwise.splitwise2023.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpensePayingUser extends BaseModel {
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private double amount;
}
