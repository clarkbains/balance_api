package com.clarkbains.roommates.ResponseModels;

import java.sql.Timestamp;

public class Auth {
    private String sessionToken;
    private Timestamp validTo;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Timestamp getValidTo() {
        return validTo;
    }

    public void setValidTo(Timestamp validTo) {
        this.validTo = validTo;
    }
}
