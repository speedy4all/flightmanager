package com.p5.flightmanager.service.exceptions;

public class NoFlightException extends RuntimeException {

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }

    ApiError apiError;

    public NoFlightException() {
    }

    public NoFlightException(ApiError error) {
        this.apiError = error;
    }


    @Override
    public String getMessage() {
        return "No flight found";
    }

}
