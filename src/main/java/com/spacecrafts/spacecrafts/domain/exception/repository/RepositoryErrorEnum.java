package com.spacecrafts.spacecrafts.domain.exception.repository;

public enum RepositoryErrorEnum {
    NOT_FOUND_ID( "THERE IS NO SPACECRAFT FOR THIS ID"),
    NOT_FOUND_NAME( "THERE IS NO SPACECRAFT FOR THIS NAME");
    private final String errorDescription;

    private RepositoryErrorEnum(String errorDescription){
        this.errorDescription=errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
