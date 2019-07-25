package com.p5.flightmanager.service.exceptions;

import javax.persistence.OneToOne;

public class FlightException extends RuntimeException {

    public FlightException() {
    }

    ApiError apiError;

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }

    public FlightException(ApiError apiError) {
        this.apiError = apiError;
    }
}
