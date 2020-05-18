package com.clarkbains.roommates.models.Response.Errors.Generic;

public class AuthenticationErrorResponse extends ErrorResponse {
    public AuthenticationErrorResponse(){
        this.info = "There was an error with authentication";
    }
}
