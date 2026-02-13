package com.Gangadhar.expenseapp.service.impl;

import com.Gangadhar.expenseapp.entity.Expense;
import com.Gangadhar.expenseapp.entity.ExpenseSplit;
import com.Gangadhar.expenseapp.entity.User;
import com.Gangadhar.expenseapp.repository.ExpenseRepository;
import com.Gangadhar.expenseapp.repository.ExpenseSplitRepository;
import com.Gangadhar.expenseapp.repository.UserRepository;
import com.Gangadhar.expenseapp.service.ExpenseSplitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseSplitServiceImpl implements ExpenseSplitService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final ExpenseSplitRepository expenseSplitRepository;

    public ExpenseSplitServiceImpl(
            ExpenseRepository expenseRepository,
            UserRepository userRepository,
            ExpenseSplitRepository expenseSplitRepository) {

        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.expenseSplitRepository = expenseSplitRepository;
    }

    @Override
    public void splitExpenseEqually(Long expenseId, List<Long> userIds) {

        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        double splitAmount = expense.getAmount() / userIds.size();

        for (Long userId : userIds) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            ExpenseSplit split = new ExpenseSplit();
            split.setExpense(expense);
            split.setUser(user);
            split.setAmount(splitAmount);

            expenseSplitRepository.save(split);
        }
    }
}
