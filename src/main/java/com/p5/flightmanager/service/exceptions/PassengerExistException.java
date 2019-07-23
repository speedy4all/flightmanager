package com.p5.flightmanager.service.exceptions;

public class PassengerExistException extends RuntimeException {

    ApiError apiError=new ApiError() ;
    public PassengerExistException(String message) {
        super(message);
        apiError.setMessage("Passenger with identifier"+message+"is already present!");
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}
