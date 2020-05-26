package com.clarkbains.roommates.models.Response.Successes.Transactions;

import com.clarkbains.roommates.models.Response.Successes.User.UserResponse;

import java.awt.print.Book;

public class GetSingleTransaction {
    public Double amount;
    public UserResponse owedTo;
    public Boolean isSelf = false;
    public String note;

    public GetSingleTransaction(Double amount, UserResponse owedTo, Boolean isSelf, String note) {
        this.amount = amount;
        this.owedTo = owedTo;
        this.note = note;
        this.isSelf = isSelf;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public UserResponse getOwedTo() {
        return owedTo;
    }

    public void setOwedTo(UserResponse owedTo) {
        this.owedTo = owedTo;
    }

    public Boolean getSelf() {
        return isSelf;
    }

    public void setSelf(Boolean self) {
        isSelf = self;
    }
}
