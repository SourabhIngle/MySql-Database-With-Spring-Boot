package com.bridgelabz.mysqldatabase.exception;

//This exception handler for service layer.
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
