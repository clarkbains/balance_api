package com.clarkbains.roommates.models.Request.Groups.Member;

import com.clarkbains.roommates.models.Request.AuthenticatedRequest;

import javax.validation.Valid;

public class AddUserToGroupRequest extends AuthenticatedRequest {
    @Valid
    private Integer[] ids;
    @Valid
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
}
