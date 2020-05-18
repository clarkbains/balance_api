package com.clarkbains.roommates.models.Request;

import javax.validation.constraints.NotNull;

public class AuthenticatedRequest {
    public String getxAuth() {
        return xAuth;
    }
    public void getAuthFromReq(AuthenticatedRequest req){
        xAuth = req.getxAuth();
    }

    @NotNull
    private String xAuth;
}
