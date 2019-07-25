package com.p5.flightmanager.service.exceptions;

public class NoPassengerException extends RuntimeException {

    private ApiError apiError;

    public NoPassengerException(){

    }

    public NoPassengerException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }

    @Override
    public String getMessage(){
        return "No passenger found!";
    }
}