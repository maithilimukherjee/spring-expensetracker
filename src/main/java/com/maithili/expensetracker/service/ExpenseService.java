package com.maithili.expensetracker.service;

import com.maithili.expensetracker.models.RequestDTO;
import com.maithili.expensetracker.models.ResponseDTO;
import com.maithili.expensetracker.entity.Category;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {

    void addExpense(RequestDTO requestDTO);

    void updateExpense(Long id, RequestDTO requestDTO);

    void deleteExpense(Long id);

    ResponseDTO getExpenseById(Long id);

    List<ResponseDTO> getAllExpenses();

    List<ResponseDTO> getExpensesByCategory(Category category);

    List<ResponseDTO> getExpensesByDateRange(LocalDate start, LocalDate end);

    List<ResponseDTO> getExpensesByCategoryAndDateRange(Category category, LocalDate start, LocalDate end);

    List<ResponseDTO> getExpensesByDate(LocalDate date);

    List<ResponseDTO> getExpensesSortedByDate();

    List<ResponseDTO> getExpensesSortedByAmount();
}