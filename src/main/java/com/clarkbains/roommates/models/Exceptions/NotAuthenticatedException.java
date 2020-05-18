package com.clarkbains.roommates.models.Exceptions;

public class NotAuthenticatedException extends Exception {
    private String type;
    public NotAuthenticatedException(String type){
        this.type = type;
    }
    public NotAuthenticatedException(){
        this("Unknown");
    }
}
