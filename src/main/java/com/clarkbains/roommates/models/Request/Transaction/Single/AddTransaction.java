package com.clarkbains.roommates.models.Request.Transaction.Single;

import com.clarkbains.roommates.models.Request.AuthenticatedRequest;

import javax.validation.constraints.NotNull;

public class AddTransaction extends AuthenticatedRequest {
    @NotNull
    private Integer targetUserId;
    private String note;
    @NotNull
    private Double amount;

    public Integer getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Integer targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
