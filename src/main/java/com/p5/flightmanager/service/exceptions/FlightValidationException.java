package com.p5.flightmanager.service.exceptions;

public class FlightValidationException extends RuntimeException {

    private ApiError apiError;

    public FlightValidationException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }

}
