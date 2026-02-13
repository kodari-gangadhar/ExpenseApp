package com.Gangadhar.expenseapp.service.impl;

import com.Gangadhar.expenseapp.dto.BalanceResponse;
import com.Gangadhar.expenseapp.entity.Expense;
import com.Gangadhar.expenseapp.entity.ExpenseSplit;
import com.Gangadhar.expenseapp.repository.ExpenseRepository;
import com.Gangadhar.expenseapp.repository.ExpenseSplitRepository;
import com.Gangadhar.expenseapp.service.BalanceService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseSplitRepository expenseSplitRepository;

    public BalanceServiceImpl(ExpenseRepository expenseRepository,
                              ExpenseSplitRepository expenseSplitRepository) {
        this.expenseRepository = expenseRepository;
        this.expenseSplitRepository = expenseSplitRepository;
    }

    @Override
    public List<BalanceResponse> calculateBalances() {

        Map<Long, Double> balanceMap = new HashMap<>();

        List<Expense> expenses = expenseRepository.findAll();

        for (Expense expense : expenses) {
            Long payerId = expense.getUser().getId();
            double totalAmount = expense.getAmount();

            balanceMap.put(payerId,
                    balanceMap.getOrDefault(payerId, 0.0) + totalAmount);

            List<ExpenseSplit> splits =
                    expenseSplitRepository.findByExpenseId(expense.getId());

            for (ExpenseSplit split : splits) {
                Long userId = split.getUser().getId();
                double share = split.getAmount();

                balanceMap.put(userId,
                        balanceMap.getOrDefault(userId, 0.0) - share);
            }
        }

        List<BalanceResponse> result = new ArrayList<>();

        List<Long> users = new ArrayList<>(balanceMap.keySet());

        for (Long from : users) {
            for (Long to : users) {
                if (!from.equals(to)) {
                    double amount = balanceMap.get(from);

                    if (amount < 0 && balanceMap.get(to) > 0) {
                        double settled = Math.min(-amount, balanceMap.get(to));

                        if (settled > 0) {
                            result.add(new BalanceResponse(from, to, settled));
                            balanceMap.put(from, amount + settled);
                            balanceMap.put(to, balanceMap.get(to) - settled);
                        }
                    }
                }
            }
        }

        return result;
    }
}
