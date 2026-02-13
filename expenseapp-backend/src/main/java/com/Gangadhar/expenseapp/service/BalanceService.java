package com.Gangadhar.expenseapp.service;

import com.Gangadhar.expenseapp.dto.BalanceResponse;
import java.util.List;

public interface BalanceService {
    List<BalanceResponse> calculateBalances();
}
