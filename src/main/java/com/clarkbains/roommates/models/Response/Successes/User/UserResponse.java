package com.clarkbains.roommates.models.Response.Successes.User;

import com.clarkbains.roommates.models.Database.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserResponse{
    private String name;
    private String email;
    private Integer id;

    public UserResponse(String name, String email, Integer id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }
    public UserResponse(User u){
        this(u.getName(), u.getEmail(),u.getId());

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }
}
