package com.p5.flightmanager.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class FlightDtoSimple {

    private UUID id;
    private String name;
    private String departureLocation;
    private Date departureDate;
    private String destinationLocation;
    private Date destinationDate;


    public FlightDtoSimple() {
    }

    public FlightDtoSimple(UUID id, String name, Date departureDate, String departureLocation, Date destinationDate, String destinationLocation) {
        this.id = id;
        this.name = name;
        this.departureDate = departureDate;
        this.departureLocation = departureLocation;
        this.destinationDate = destinationDate;
        this.destinationLocation = destinationLocation;
    }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public Date getDepartureDate() { return departureDate; }

    public void setDepartureDate(Date departureDate) { this.departureDate = departureDate; }

    public Date getDestinationDate() { return destinationDate; }

    public void setDestinationDate(Date destinationDate) { this.destinationDate = destinationDate; }

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
