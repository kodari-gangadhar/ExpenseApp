package com.Gangadhar.expenseapp.service.impl;

import com.Gangadhar.expenseapp.entity.Expense;
import com.Gangadhar.expenseapp.repository.ExpenseRepository;
import com.Gangadhar.expenseapp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
