package com.clarkbains.roommates.models.Response.Successes.Group;

import com.clarkbains.roommates.models.Database.Group;
import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.models.Response.Successes.User.UserResponse;

public class GroupResponse {
    private String groupName;
    private String address;
    private UserResponse owner;
    private Integer id;

    public GroupResponse(String groupName, String address, UserResponse owner, Integer id) {
        this.groupName = groupName;
        this.address = address;
        this.owner = owner;
        this.id = id;
    }
    public GroupResponse(Group g, UserResponse u){
        this(g.getGroup_name(),g.getAddress(),u,g.getId());
    }
}
