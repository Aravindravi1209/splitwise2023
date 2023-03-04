package com.splitwise.splitwise2023.services.settleup;

import com.splitwise.splitwise2023.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private double amount;

    public Transaction(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}
