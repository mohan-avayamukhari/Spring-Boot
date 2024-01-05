package com.aditya.employees.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ExceptionObject {
    private HttpStatus httpStatus;
    private int statusCode;
    private String msg;
    private Date timeStamp;
}
