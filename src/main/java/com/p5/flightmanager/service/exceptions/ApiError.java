package com.p5.flightmanager.service.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors= new ArrayList<>();

    private ApiError(){timestamp=LocalDateTime.now();}
    ApiError(HttpStatus status){
        this();
        this.status=status;
    }


    ApiError(HttpStatus status, String message, Throwable ex){
        this();
        this.status=status;
        this.message=message;
        this.debugMessage=ex.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }
}
