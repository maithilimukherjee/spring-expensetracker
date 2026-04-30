package com.maithili.expensetracker.entity;
import java.time.LocalDate;
import com.maithili.expensetracker.entity.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "expenses")


public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Category category;
    private double amount;
    private LocalDate date;

    // Getters and Setters

    public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
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

public LocalDate getDate() {
    return date;
}

public void setDate(LocalDate date) {
    this.date = date;
}

}
