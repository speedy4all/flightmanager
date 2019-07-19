package com.p5.flightmanager.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDto {

    private String id;
    private String name;
    private Date departureDate;
    private Date destinationDate;
    private String departureLocation;
    private Double durationTime;
    private String fullFlightDescription;
    private FlightType flightType;
    private PlaneDto plane;
    private AirportDto destinationAirport;
    private AirportDto locationAirport;
    private List<PassengerDto> passengers = new ArrayList<>();

    public FlightDto() {
    }

    public FlightDto(String name, String departureLocation, Date departureDate) {
        this.name = name;
        this.departureLocation = departureLocation;
        this.departureDate = departureDate;
    }

    public PlaneDto getPlane() {
        return plane;
    }

    public void setPlane(PlaneDto plane) {
        this.plane = plane;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
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

    public Double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Double durationTime) {
        this.durationTime = durationTime;
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

    public String getFullFlightDescription() {
        return fullFlightDescription;
    }

    public void setFullFlightDescription(String fullFlightDescription) {
        this.fullFlightDescription = fullFlightDescription;
    }

    public List<PassengerDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDto> passengers) {
        this.passengers = passengers;
    }

    public AirportDto getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(AirportDto destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public AirportDto getLocationAirport() {
        return locationAirport;
    }

    public void setLocationAirport(AirportDto locationAirport) {
        this.locationAirport = locationAirport;
    }

}
