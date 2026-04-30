package com.maithili.expensetracker.controller;

import com.maithili.expensetracker.entity.Category;
import com.maithili.expensetracker.models.RequestDTO;
import com.maithili.expensetracker.models.ResponseDTO;
import com.maithili.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseDTO addExpense(@RequestBody RequestDTO requestDTO) {
        return expenseService.addExpense(requestDTO);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateExpense(@PathVariable Long id, @RequestBody RequestDTO requestDTO) {
        expenseService.updateExpense(id, requestDTO);
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/{id}")
    public ResponseDTO getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @GetMapping
    public List<ResponseDTO> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/category/{category}")
    public List<ResponseDTO> getByCategory(@PathVariable Category category) {
        return expenseService.getExpensesByCategory(category);
    }

    @GetMapping("/date")
    public List<ResponseDTO> getByDate(@RequestParam String date) {
        return expenseService.getExpensesByDate(LocalDate.parse(date));
    }

    @GetMapping("/range")
    public List<ResponseDTO> getByDateRange(@RequestParam String start,
                                           @RequestParam String end) {
        return expenseService.getExpensesByDateRange(
                LocalDate.parse(start),
                LocalDate.parse(end)
        );
    }

    @GetMapping("/category-range")
    public List<ResponseDTO> getByCategoryAndRange(@RequestParam Category category,
                                                  @RequestParam String start,
                                                  @RequestParam String end) {
        return expenseService.getExpensesByCategoryAndDateRange(
                category,
                LocalDate.parse(start),
                LocalDate.parse(end)
        );
    }

    @GetMapping("/sort/date")
    public List<ResponseDTO> getSortedByDate() {
        return expenseService.getExpensesSortedByDate();
    }

    @GetMapping("/sort/amount")
    public List<ResponseDTO> getSortedByAmount() {
        return expenseService.getExpensesSortedByAmount();
    }
}