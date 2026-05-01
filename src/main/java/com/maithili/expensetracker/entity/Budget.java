package com.maithili.expensetracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Budget {

    @Id
    private Long id = 1L;

    private double amount;

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}