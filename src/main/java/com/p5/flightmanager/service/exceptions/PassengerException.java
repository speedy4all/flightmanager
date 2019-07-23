package com.p5.flightmanager.service.exceptions;

public class PassengerException extends RuntimeException {

    public PassengerException() {
    }

    @Override
    public String getMessage() {
        return "Wrong passenger";
    }

}
