package com.maithili.expensetracker.service;

import com.maithili.expensetracker.entity.Category;
import com.maithili.expensetracker.entity.Expense;
import com.maithili.expensetracker.models.RequestDTO;
import com.maithili.expensetracker.models.ResponseDTO;
import com.maithili.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseServiceImplementation implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImplementation(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ResponseDTO addExpense(RequestDTO requestDTO) {
        Expense expense = new Expense();
        expense.setCategory(requestDTO.getCategory());
        expense.setAmount(requestDTO.getAmount());
        expense.setDate(requestDTO.getDate());  
        Expense savedExpense = expenseRepository.save(expense);
        return new ResponseDTO(savedExpense);
    }

    @Override
    public void updateExpense(Long id, RequestDTO requestDTO) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setCategory(requestDTO.getCategory());
        expense.setAmount(requestDTO.getAmount());
        expense.setDate(requestDTO.getDate());

        expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public ResponseDTO getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        return new ResponseDTO(expense);
    }

    @Override
    public List<ResponseDTO> getAllExpenses() {
        return ResponseDTO.fromList(expenseRepository.findAll());
    }

    @Override
    public List<ResponseDTO> getExpensesByCategory(Category category) {
        return ResponseDTO.fromList(expenseRepository.findByCategory(category));
    }

    @Override
    public List<ResponseDTO> getExpensesByDateRange(LocalDate start, LocalDate end) {
        return ResponseDTO.fromList(expenseRepository.findByDateBetween(start, end));
    }

    @Override
    public List<ResponseDTO> getExpensesByCategoryAndDateRange(Category category, LocalDate start, LocalDate end) {
        return ResponseDTO.fromList(
                expenseRepository.findByCategoryAndDateBetween(category, start, end)
        );
    }

    @Override
    public List<ResponseDTO> getExpensesByDate(LocalDate date) {
        return ResponseDTO.fromList(expenseRepository.findByDate(date));
    }

    @Override
    public List<ResponseDTO> getExpensesSortedByDate() {
        return ResponseDTO.fromList(expenseRepository.findAllByOrderByDateDesc());
    }

    @Override
    public List<ResponseDTO> getExpensesSortedByAmount() {
        return ResponseDTO.fromList(expenseRepository.findAllByOrderByAmountDesc());
    }
}