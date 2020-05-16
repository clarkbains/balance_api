package com.clarkbains.roommates.models.Response.Successes.Generic;

public class Resource<T> extends SuccessResponse{
    public T resource;
    public Resource (T resource){
        this.resource = resource;
    }
}
