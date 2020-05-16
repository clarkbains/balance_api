package com.clarkbains.roommates.models.Response.Errors.Generic;

public class AuthError extends ErrorResponse {
    public AuthError(){
        this.info = "There was an error with authentication";
    }
}
