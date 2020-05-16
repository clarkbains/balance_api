package com.clarkbains.roommates.models.Request.User;

import javax.validation.constraints.NotNull;

public class Post {
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
