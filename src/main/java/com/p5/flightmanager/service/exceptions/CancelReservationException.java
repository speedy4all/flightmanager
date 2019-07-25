package com.p5.flightmanager.service.exceptions;

public class CancelReservationException extends RuntimeException {
    private ApiError apiError;

    public CancelReservationException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}
