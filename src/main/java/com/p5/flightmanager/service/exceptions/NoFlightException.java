package com.p5.flightmanager.service.exceptions;

public class NoFlightException extends RuntimeException {
//test

    public NoFlightException() {
    }

    @Override
    public String getMessage() {
        return "No flight found";
    }

}
