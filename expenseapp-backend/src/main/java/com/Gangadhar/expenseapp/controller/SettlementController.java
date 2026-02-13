package com.Gangadhar.expenseapp.controller;

import com.Gangadhar.expenseapp.dto.SettlementRequest;
import com.Gangadhar.expenseapp.service.SettlementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settle")
public class SettlementController {

    private final SettlementService settlementService;

    public SettlementController(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @PostMapping
    public String settle(@RequestBody SettlementRequest request) {
        settlementService.settle(request);
        return "Settlement successful";
    }
}
