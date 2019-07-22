package com.p5.flightmanager.service.exceptions;

public class ApiSubError {

    private String fieldName;
    private String message;
    private String recievedValue;

    public ApiSubError() {
    }

    public ApiSubError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public ApiSubError(String fieldName, String message, String recievedValue) {
        this.fieldName = fieldName;
        this.message = message;
        this.recievedValue = recievedValue;
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

    public String getRecievedValue() {
        return recievedValue;
    }

    public void setRecievedValue(String recievedValue) {
        this.recievedValue = recievedValue;
    }
}
