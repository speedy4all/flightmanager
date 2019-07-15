package com.p5.flightmanager.service.exceptions;

public class EmptyFieldException extends RuntimeException {

    public EmptyFieldException() {}

    @Override
    public String getMessage() {
        return "Field is not valid";
    }
}
