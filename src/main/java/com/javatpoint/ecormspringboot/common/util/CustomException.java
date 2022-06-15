package com.javatpoint.ecormspringboot.common.util;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception{
    private HttpStatus status;
    public CustomException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
