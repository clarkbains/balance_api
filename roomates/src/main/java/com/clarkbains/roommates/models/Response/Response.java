package com.clarkbains.roommates.models.Response;

import java.util.HashMap;
import java.util.Map;

public abstract class Response {
    public String responseClass;
    public String info;
    public String type;
    public Response(String type){
        this.type = type;
        responseClass = this.getClass().getCanonicalName();
    }

}
