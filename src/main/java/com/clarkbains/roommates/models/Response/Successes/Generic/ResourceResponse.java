package com.clarkbains.roommates.models.Response.Successes.Generic;

public class ResourceResponse<T> extends SuccessResponse{
    public T resource;
    public ResourceResponse(T resource){
        this.resource = resource;
    }
}
