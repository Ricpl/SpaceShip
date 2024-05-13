package com.spacecrafts.spacecrafts.domain.exception.rest;

public enum RestErrorEnum {
    ID_VALUE_ERROR( "ID MUST BE POSITIVE"),
    EMPTY_FIELD_ERROR( "ALL FIELDS MUST NOT BE EMPTY"),
    FIELD_NOT_EMPTY( "ID AND, AT LEAST, ONE FIELD ARE MANDATORY");
    private final String errorDescription;

    private RestErrorEnum(String errorDescription){
        this.errorDescription=errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
