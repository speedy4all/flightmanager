package com.p5.flightmanager.service.exceptions;

public class NoAirplaneException extends RuntimeException {

    public NoAirplaneException() {
    }

    @Override
    public String getMessage(){
        return "No airplane found";
    }

}
