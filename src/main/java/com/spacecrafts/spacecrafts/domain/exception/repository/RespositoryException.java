package com.spacecrafts.spacecrafts.domain.exception.repository;


public class RespositoryException extends RuntimeException{
    private final RepositoryErrorEnum error;

    public RespositoryException(RepositoryErrorEnum error){
        super();
        this.error=error;
    }

    public RepositoryErrorEnum getError() {
        return error;
    }
}
