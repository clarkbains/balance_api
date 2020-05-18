package com.clarkbains.roommates.models.Response.Errors.Generic;

import com.clarkbains.roommates.models.Response.Response;

public class ErrorResponse extends Response {
    public ErrorResponse(){
       super("failure");
    }
}
