package com.p5.flightmanager.service.exceptions;

public class NoPassagerException extends RuntimeException{
    public NoPassagerException(){

    }
    @Override
    public String getMessage (){
        return "No passenger found";
    }

}
