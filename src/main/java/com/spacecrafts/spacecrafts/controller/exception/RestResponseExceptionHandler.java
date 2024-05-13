package com.spacecrafts.spacecrafts.controller.exception;

import com.spacecrafts.spacecrafts.domain.exception.repository.RespositoryException;
import com.spacecrafts.spacecrafts.domain.exception.rest.RestValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler({RestValidationException.class})
    public ResponseEntity<Object> handleValidationRestException(RestValidationException exception){
        return new ResponseEntity<>( exception.getError().getErrorDescription(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RespositoryException.class})
    public ResponseEntity<Object> handleValidationRestException(RespositoryException exception){
        return new ResponseEntity<>( exception.getError().getErrorDescription(),HttpStatus.NOT_FOUND);
    }
}
