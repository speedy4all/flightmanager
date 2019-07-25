package com.p5.flightmanager.service.exceptions;

public class NoPassengerInListException extends RuntimeException {

    public NoPassengerInListException(){

    }

    @Override
    public String getMessage(){
        return "No passenger found in passengers list!";
    }
}