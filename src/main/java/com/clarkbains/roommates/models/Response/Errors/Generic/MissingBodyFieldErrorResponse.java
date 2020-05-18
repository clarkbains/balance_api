package com.clarkbains.roommates.models.Response.Errors.Generic;

import java.util.ArrayList;
import java.util.List;

public class MissingBodyFieldErrorResponse extends ErrorResponse {

    public List<String> missingFields;
    public MissingBodyFieldErrorResponse(){
        missingFields = new ArrayList<>();
        this.info = "Fields are missing in your request body";
    }
    public List <String> getMissingFields() {
        return missingFields;
    }
}
