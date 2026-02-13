package com.Gangadhar.expenseapp.service.impl;

import com.Gangadhar.expenseapp.dto.SettlementRequest;
import com.Gangadhar.expenseapp.entity.Settlement;
import com.Gangadhar.expenseapp.entity.User;
import com.Gangadhar.expenseapp.repository.SettlementRepository;
import com.Gangadhar.expenseapp.repository.UserRepository;
import com.Gangadhar.expenseapp.service.SettlementService;
import org.springframework.stereotype.Service;

@Service
public class SettlementServiceImpl implements SettlementService {

    private final SettlementRepository settlementRepository;
    private final UserRepository userRepository;

    public SettlementServiceImpl(SettlementRepository settlementRepository,
                                 UserRepository userRepository) {
        this.settlementRepository = settlementRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void settle(SettlementRequest request) {

        User fromUser = userRepository.findById(request.getFromUserId())
                .orElseThrow(() -> new RuntimeException("From user not found"));

        User toUser = userRepository.findById(request.getToUserId())
                .orElseThrow(() -> new RuntimeException("To user not found"));

        Settlement settlement = new Settlement();
        settlement.setFromUser(fromUser);
        settlement.setToUser(toUser);
        settlement.setAmount(request.getAmount());

        settlementRepository.save(settlement);
    }
}
