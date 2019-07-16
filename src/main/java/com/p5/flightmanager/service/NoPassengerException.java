package com.p5.flightmanager.service;

public class NoPassengerException extends RuntimeException {

    public NoPassengerException() {}

    @Override
    public String getMessage() {
        return "No passenger found";
    }
}
