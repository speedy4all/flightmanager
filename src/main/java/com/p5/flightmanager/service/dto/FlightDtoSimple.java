package com.p5.flightmanager.service.dto;

import java.util.Date;
import java.util.UUID;

public class FlightDtoSimple {
    private UUID id;
    private Date departureDate;
    private Date destinationDate;
    private Double durationTime;
    private int seatsAvailable;
    private String name;
    private FlightType flightType;
    private String departureAirportName;
    private UUID idDepartureAirport;
    private String departureAirportCode;
    private String destinationAirportName;
    private UUID idDestinationAirport;
    private String destinationAirportCode;

    public UUID getIdDepartureAirport() {
        return idDepartureAirport;
    }

    public void setIdDepartureAirport(UUID idDepartureAirport) {
        this.idDepartureAirport = idDepartureAirport;
    }

    public UUID getIdDestinationAirport() {
        return idDestinationAirport;
    }

    public void setIdDestinationAirport(UUID idDestinationAirport) {
        this.idDestinationAirport = idDestinationAirport;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
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
}
