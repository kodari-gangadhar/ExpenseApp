package com.Gangadhar.expenseapp.repository;

import com.Gangadhar.expenseapp.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
