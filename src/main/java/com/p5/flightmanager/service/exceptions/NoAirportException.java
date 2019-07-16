package com.p5.flightmanager.service.exceptions;

public class NoAirportException extends RuntimeException {

    public NoAirportException() {
    }

    @Override
    public String getMessage() {
        return "No airport found";
    }
}
