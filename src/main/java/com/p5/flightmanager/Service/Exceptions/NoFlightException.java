package com.p5.flightmanager.Service.Exceptions;

public class NoFlightException extends RuntimeException {
    public NoFlightException(){

    }

    @Override
    public String getMessage(){
        return "No flight found";
    }
}
