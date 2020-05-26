package com.clarkbains.roommates.models.Response.Successes.Transactions;

import com.clarkbains.roommates.models.Response.Successes.Group.GroupResponse;
import com.clarkbains.roommates.models.Response.Successes.User.UserResponse;

public class GetGroupTransaction extends  GetSingleTransaction{
    private GroupResponse group;
    public GetGroupTransaction(Double amount, UserResponse owedTo, Boolean isSelf, String note, GroupResponse group) {
        super(amount, owedTo, isSelf, note);
        this.group = group;
    }
}
