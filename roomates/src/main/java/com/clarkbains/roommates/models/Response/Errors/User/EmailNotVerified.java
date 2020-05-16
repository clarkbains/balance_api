package com.clarkbains.roommates.models.Response.Errors.User;

import com.clarkbains.roommates.models.Response.Errors.Generic.ErrorResponse;

public class EmailNotVerified extends ErrorResponse {
    public EmailNotVerified(){
        this.info = "Please Verify your email before logging in";
    }
}
