package com.clarkbains.roommates.models.Response.Successes.User.Public;

import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.models.Response.Successes.Generic.SuccessResponse;

public class PublicUserResponse{
    public String name;
    public Integer id;

    public PublicUserResponse(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public static PublicUserResponse fromDatabaseEntity(User u){
        return new PublicUserResponse(u.getName(), u.getId());
    }
}
