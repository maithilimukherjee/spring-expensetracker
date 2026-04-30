package com.maithili.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maithili.expensetracker.entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    
}