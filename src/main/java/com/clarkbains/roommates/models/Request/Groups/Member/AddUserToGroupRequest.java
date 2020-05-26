package com.clarkbains.roommates.models.Request.Groups.Member;

import com.clarkbains.roommates.models.Request.AuthenticatedRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AddUserToGroupRequest extends AuthenticatedRequest {
    @NotNull
    private Integer[] ids;
    @NotNull
    private Integer groupId;


    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public AddUserToGroupRequest(@Valid Integer[] ids, @Valid Integer groupId) {
        this.ids = ids;
        this.groupId = groupId;
    }
}
