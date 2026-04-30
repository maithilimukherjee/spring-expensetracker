package com.maithili.expensetracker.models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.maithili.expensetracker.entity.Expense;
import com.maithili.expensetracker.entity.Category;
import com.maithili.expensetracker.repository.ExpenseRepository;
import com.maithili.expensetracker.models.RequestDTO;


public class ResponseDTO
{
    private Long id;
    private Category category;
    private double amount;
    private LocalDate date;

    public ResponseDTO()
    {}

    public ResponseDTO(Expense expense)
    {
        if (expense == null) 
        {
        throw new IllegalArgumentException("Expense cannot be null");
        }

        this.id=expense.getId();
        this.category=expense.getCategory();
        this.amount=expense.getAmount();
        this.date=expense.getDate();
    }

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

    public static List<ResponseDTO> fromList(List<Expense> expenses) {
    List<ResponseDTO> responseList = new ArrayList<>();
    for (Expense expense : expenses) {
        responseList.add(new ResponseDTO(expense));
    }
    return responseList;
}
}