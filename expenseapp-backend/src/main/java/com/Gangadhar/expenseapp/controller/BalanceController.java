package com.Gangadhar.expenseapp.controller;

import com.Gangadhar.expenseapp.dto.BalanceResponse;
import com.Gangadhar.expenseapp.service.BalanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balances")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping
    public List<BalanceResponse> getBalances() {
        return balanceService.calculateBalances();
    }
}
