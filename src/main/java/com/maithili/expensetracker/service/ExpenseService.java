package com.maithili.expensetracker.service;

import java.time.LocalDate;
import java.util.List;

import com.maithili.expensetracker.entity.Category;
import com.maithili.expensetracker.models.RequestDTO;
import com.maithili.expensetracker.models.ResponseDTO;

public interface ExpenseService {

    ResponseDTO addExpense(RequestDTO requestDTO);

    void updateExpense(Long id, RequestDTO requestDTO);

    void deleteExpense(Long id);

    void setBudget(double amount);

    double getTotalExpenses();

    String checkBudgetStatus();

    ResponseDTO getExpenseById(Long id);

    List<ResponseDTO> getAllExpenses();

    List<ResponseDTO> getExpensesByCategory(Category category);

    List<ResponseDTO> getExpensesByDateRange(LocalDate start, LocalDate end);

    List<ResponseDTO> getExpensesByCategoryAndDateRange(Category category, LocalDate start, LocalDate end);

    List<ResponseDTO> getExpensesByDate(LocalDate date);

    List<ResponseDTO> getExpensesSortedByDate();

    List<ResponseDTO> getExpensesSortedByAmount();
}