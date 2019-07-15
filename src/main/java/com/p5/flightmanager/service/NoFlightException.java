package com.p5.flightmanager.service;


public class NoFlightException extends RuntimeException {
    public NoFlightException() {
        
    }

    @Override
    public String getMessage(){
        return "No flight found.";
    }
}
