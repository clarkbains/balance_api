package com.clarkbains.roommates.models.Response.Errors.Generic;

public class JsonErrorResponse extends ErrorResponse {
    public String jsonParseError;
    public JsonErrorResponse(String jsonParseError){
        this.info = "There was an error with JSON parsing";
        this.jsonParseError = jsonParseError;
    }
}
