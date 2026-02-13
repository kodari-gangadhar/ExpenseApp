package com.Gangadhar.expenseapp.service;

import java.util.List;

public interface ExpenseSplitService {

    void splitExpenseEqually(Long expenseId, List<Long> userIds);
}
