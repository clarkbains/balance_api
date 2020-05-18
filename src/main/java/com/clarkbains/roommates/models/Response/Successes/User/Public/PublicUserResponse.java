package com.clarkbains.roommates.models.Response.Successes.User.Public;

import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.models.Response.Successes.Generic.SuccessResponse;

public class PublicUserResponse extends User {
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
