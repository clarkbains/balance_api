package com.clarkbains.roommates.models.Request.Groups;

import com.clarkbains.roommates.models.Request.AuthenticatedRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AddGroupRequest extends AuthenticatedRequest {

    public String getGroupName() {
        return groupName;
    }

    public String getAddress() {
        return address;
    }
    private Boolean addSelf = Boolean.FALSE;


    public Boolean getAddSelf() {
        return addSelf;
    }
    @NotNull
    private String groupName;

    @NotNull
    private String address;

}
