package com.springapp.model;

/**
 * Created by Damqnov on 14-4-2.
 */
public class Error {

    private String errorMessage;

    public Error(String errorMessage){
        setErrorMessage(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
