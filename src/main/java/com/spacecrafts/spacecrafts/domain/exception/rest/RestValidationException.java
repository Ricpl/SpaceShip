package com.spacecrafts.spacecrafts.domain.exception.rest;


public class RestValidationException extends RuntimeException{
    private final RestErrorEnum error;

    public RestValidationException(RestErrorEnum error){
        super();
        this.error=error;
    }

    public RestErrorEnum getError() {
        return error;
    }
}
