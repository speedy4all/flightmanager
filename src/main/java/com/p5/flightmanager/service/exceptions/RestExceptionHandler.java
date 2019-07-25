package com.p5.flightmanager.service.exceptions;

import com.p5.flightmanager.service.dto.CancelReservationDto;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.bind.ValidationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";

        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }

    @ExceptionHandler(NoFlightException.class)
    protected ResponseEntity<Object> handleNoFlightException(NoFlightException ex) {

        return buildResponseEntity(ex.getApiError());
    }

    @ExceptionHandler(NoPassengerException.class)
    protected  ResponseEntity<Object> handleNoPassengerException(NoPassengerException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());

        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(NoAirportException.class)
    protected ResponseEntity<Object> handleNoAirportException(NoAirportException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());

        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(NoPlaneException.class)
    protected ResponseEntity<Object> handleNoPlaneException(NoPlaneException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());

        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }


    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<Object> handleValidationError(ValidationException ex) {
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "Missing arguments", ex));
    }

    @ExceptionHandler(FlightValidationException.class)
    protected ResponseEntity<Object> handleFlightValidateException(FlightValidationException ex){
        return buildResponseEntity(ex.getApiError());
    }

    @ExceptionHandler(CancelReservationException.class)
    protected ResponseEntity<Object> handleCancelReservationException(CancelReservationException ex){
        return buildResponseEntity(ex.getApiError());
    }

    @ExceptionHandler(PassengerExistException.class)
    protected ResponseEntity<Object> handlePassengerExistError(PassengerExistException ex){
        return buildResponseEntity(ex.getApiError());
    }
}