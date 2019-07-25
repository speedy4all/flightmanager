package com.p5.flightmanager.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDtoSimple {

    private String name;
    private String departureLocation;
    private String destinationLocation;

    public FlightDtoSimple() {
    }

    public FlightDtoSimple(String name, String departureLocation, String destinationLocation) {
        this.name = name;
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
}
