package com.p5.flightmanager.service.exceptions;

public class ApiSubError {
    private String fieldName;
    private String receivedValue;
    private String message;

    public ApiSubError() {
    }

    public ApiSubError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public ApiSubError(String fieldName, String receivedValue, String message) {
        this.fieldName = fieldName;
        this.receivedValue = receivedValue;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getReceivedValue() {
        return receivedValue;
    }

    public void setReceivedValue(String receivedValue) {
        this.receivedValue = receivedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
