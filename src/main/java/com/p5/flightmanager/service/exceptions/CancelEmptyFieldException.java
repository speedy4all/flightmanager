package com.p5.flightmanager.service.exceptions;

public class CancelEmptyFieldException extends RuntimeException {

    public CancelEmptyFieldException() {}

    @Override
    public String getMessage() {
        return "Field is empty!";
    }
}