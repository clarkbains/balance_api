package com.clarkbains.roommates.models.Response.Errors.User;

import com.clarkbains.roommates.models.Response.Errors.Generic.ErrorResponse;

public class EmailNotVerifiedErrorResponse extends ErrorResponse {
    public EmailNotVerifiedErrorResponse(){
        this.info = "Please Verify your email before logging in";
    }
}
