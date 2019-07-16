package com.p5.flightmanager.service.dto;

public class PlaneDto {

    private String id;
    private String model;
    private Integer numberOfSeats;
    private String fullPlaneDetails;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getFullPlaneDetails() {
        return fullPlaneDetails;
    }

    public void setFullPlaneDetails(String fullPlaneDetails) {
        this.fullPlaneDetails = fullPlaneDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
