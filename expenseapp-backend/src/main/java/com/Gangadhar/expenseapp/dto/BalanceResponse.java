package com.Gangadhar.expenseapp.dto;

public class BalanceResponse {

    private Long fromUserId;
    private Long toUserId;
    private double amount;

    public BalanceResponse(Long fromUserId, Long toUserId, double amount) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.amount = amount;
    }

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
