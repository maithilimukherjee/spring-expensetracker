package com.maithili.expensetracker.repository;
import com.maithili.expensetracker.entity.Expense;
import com.maithili.expensetracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByCategory(Category category);

    List<Expense> findByDateBetween(LocalDate start, LocalDate end);

    List<Expense> findByCategoryAndDateBetween(Category category, LocalDate start, LocalDate end);

    List<Expense> findByDate(LocalDate date);

    List<Expense> findAllByOrderByDateDesc();

    List<Expense> findAllByOrderByAmountDesc();
}



    
