package com.p5.flightmanager.service.exceptions;

import org.springframework.http.HttpStatus;

public class PassengerExistException extends RuntimeException {

    ApiError apiError = new ApiError(HttpStatus.CONFLICT);

    public PassengerExistException(String message) {
        super(message);
        apiError.setMessage(String.format("Passenger with identifier: %s is already present!", message));
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}
