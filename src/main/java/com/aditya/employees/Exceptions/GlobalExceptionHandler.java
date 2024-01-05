package com.aditya.employees.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionObject> userNotFound(UserNotFoundException e, WebRequest request){
        ExceptionObject object = new ExceptionObject();
        object.setHttpStatus(HttpStatus.NOT_FOUND);
        object.setStatusCode(HttpStatus.NOT_FOUND.value());
        object.setMsg(e.getMessage());
        object.setTimeStamp(new Date());
        return new ResponseEntity<ExceptionObject>(object, HttpStatus.NOT_FOUND);
    }
}
