package com.maithili.expensetracker.models;

import com.maithili.expensetracker.entity.Category;

import java.time.LocalDate;

public class RequestDTO {
    
    private Category category;
    private Double amount;
    private LocalDate date;

    public RequestDTO() {
    }

    public RequestDTO(Category category, Double amount, LocalDate date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

}
