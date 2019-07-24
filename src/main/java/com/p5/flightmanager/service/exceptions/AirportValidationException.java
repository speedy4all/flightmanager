package com.p5.flightmanager.service.exceptions;

public class AirportValidationException extends RuntimeException {

    private ApiError apiError;

    public AirportValidationException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}
