package com.p5.flightmanager.service.exceptions;

import org.springframework.http.HttpStatus;

public class PassengerExistException extends RuntimeException {

    ApiError apiError = new ApiError(HttpStatus.CONFLICT);
    public PassengerExistException(String message) {
        super(message);
        apiError.setMessage("Passenger with identifier: " + message + " is already present!");
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}