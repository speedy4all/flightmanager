package com.p5.flightmanager.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDto {

    private String id;
    private String name;
    private String departureLocation;

    private String destinationLocation;
    private Double durationTime;
    private Date departureDate;
    private Date destinationDate;
    private String fullFlightDescription;
    private FlightType flightType;

    private List<PassengerDto> passengerDtos = new ArrayList<>();

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

    public String getFullFlightDescription() {
        return fullFlightDescription;
    }

    public void setFullFlightDescription(String fullFlightDescription) {
        this.fullFlightDescription = fullFlightDescription;
    }

    public Double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Double durationTime) {
        this.durationTime = durationTime;
    }

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

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public List<PassengerDto> getPassengerDtos() {
        return passengerDtos;
    }

    public void setPassengerDtos(List<PassengerDto> passengerDtos) {
        this.passengerDtos = passengerDtos;
    }
}
