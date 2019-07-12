package com.p5.flightmanager.service.dto;

import java.util.Date;

public class FlightDto {

    private String id;
    private String name;
    private String departureLocation;
    private String destinationLocation;
    private Double durationTime;
    private String fullFlightDescription;
    private Date departureDate;
    private Date destinationDate;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }

    public String getFullFlightDescription() {
        return fullFlightDescription;
    }

    public void setFullFlightDescription(String fullFlightDescription) {
        this.fullFlightDescription = fullFlightDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Double durationTime) {
        this.durationTime = durationTime;
    }
}
