package com.clarkbains.roommates.models.Response.Successes.User.login;

import com.clarkbains.roommates.models.Response.Successes.Generic.SuccessResponse;

import java.sql.Timestamp;

public class Post extends SuccessResponse {
    public String session;
    public Timestamp expiry;
    public Post(String sessionToken, Timestamp validTo){
        this.session = sessionToken;
        this.expiry = validTo;
    }
}
