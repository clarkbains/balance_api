package com.clarkbains.roommates.models.Request;

import javax.validation.constraints.NotNull;

public class AuthenticatedRequest {
    public String getxAuth() {
        return xAuth;
    }

    @NotNull
    private String xAuth;
}
