package com.clarkbains.roommates.models.Request.Groups;

import com.clarkbains.roommates.models.Request.AuthenticatedRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Post extends AuthenticatedRequest {

    public String getGroupName() {
        return groupName;
    }

    public String getAddress() {
        return address;
    }

    @NotNull
    private String groupName;

    @NotNull
    private String address;

}
