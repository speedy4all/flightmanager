package com.p5.flightmanager.service.exceptions;

public class ApiSubError {

    private String fieldName;
    private String message;
    private String receivedValue;

    public ApiSubError() {
    }

    public ApiSubError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public ApiSubError(String fieldName, String message, String receivedValue) {
        this.fieldName = fieldName;
        this.message = message;
        this.receivedValue = receivedValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceivedValue() {
        return receivedValue;
    }

    public void setReceivedValue(String receivedValue) {
        this.receivedValue = receivedValue;
    }
}
