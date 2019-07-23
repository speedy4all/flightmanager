package com.p5.flightmanager.service.dto;

public class FlightDtoParamSearch {

    private String name;
    private String departureId;
    private String destinationId;

    public FlightDtoParamSearch(String name, String departureId, String destinationId) {
        this.departureId = departureId;
        this.destinationId = destinationId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartureId() {
        return departureId;
    }

    public void setDepartureId(String departureId) {
        this.departureId = departureId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }
}