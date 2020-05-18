package com.clarkbains.roommates.models.Response.Errors.Generic;

public class NotFoundErrorResponse extends ErrorResponse{
    public NotFoundErrorResponse(){
        this.info = "cannot find this resource";
    }
}
