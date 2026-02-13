package com.Gangadhar.expenseapp.service;

import com.Gangadhar.expenseapp.entity.Expense;
import java.util.List;

public interface ExpenseService {

    Expense saveExpense(Expense expense);

    List<Expense> getAllExpenses();
}
