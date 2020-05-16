package com.clarkbains.roommates.models.Response.Errors.Generic;

public class JsonError extends ErrorResponse {
    public String jsonParseError;
    public JsonError(String jsonParseError){
        this.info = "There was an error with JSON parsing";
        this.jsonParseError = jsonParseError;
    }
}
