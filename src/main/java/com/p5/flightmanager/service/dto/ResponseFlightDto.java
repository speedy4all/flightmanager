package com.p5.flightmanager.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ResponseFlightDto implements Serializable {

    private UUID flightId;
    private String departureAirportName;
    private String departureAirportCode;
    private String destinationAirportName;
    private String destinationAirportCode;
    private Date departureDate;
    private Date destinationDate;
    private String planeType;
    private Double flightDuration;
    private Integer availableSeats;

    public ResponseFlightDto(UUID flightId, String departureAirportName, String departureAirportCode, String destinationAirportName, String destinationAirportCode, Date departureDate, Date destinationDate, String planeType, Double flightDuration, Integer availableSeats) {
        this.flightId = flightId;
        this.departureAirportName = departureAirportName;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportName = destinationAirportName;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
        this.planeType = planeType;
        this.flightDuration = flightDuration;
        this.availableSeats = availableSeats;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportName() {
        return destinationAirportName;
    }

    public void setDestinationAirportName(String destinationAirportName) {
        this.destinationAirportName = destinationAirportName;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
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

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public Double getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(Double flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public UUID getFlightId() {
        return flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
    }
}
