package com.Gangadhar.expenseapp.dto;

public class SettlementRequest {

    private Long fromUserId;
    private Long toUserId;
    private double amount;

    public Long getFromUserId() {
        return fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public double getAmount() {
        return amount;
    }
}
