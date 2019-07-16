package com.p5.flightmanager.service.exceptions;

public class NoPassengerException extends RuntimeException{
    public NoPassengerException(){

    }
    @Override
    public String getMessage (){
        return "No passenger found";
    }

}
