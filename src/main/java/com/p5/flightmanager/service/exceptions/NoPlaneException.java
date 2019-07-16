package com.p5.flightmanager.service.exceptions;

public class NoPlaneException extends RuntimeException {

    public NoPlaneException() {
    }

    @Override
    public String getMessage() {
        return "No airport found!";
    }
}