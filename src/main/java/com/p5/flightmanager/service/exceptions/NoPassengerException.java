package com.p5.flightmanager.service.exceptions;

import org.springframework.http.HttpStatus;

public class NoPassengerException extends RuntimeException {

    ApiError apiError = new ApiError(HttpStatus.CONFLICT);
    public NoPassengerException(String message) {
        super(message);
        apiError.setMessage("Passenger " + message + " not found!");
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}
