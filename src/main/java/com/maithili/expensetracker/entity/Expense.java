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
}
