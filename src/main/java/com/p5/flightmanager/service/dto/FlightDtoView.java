package com.p5.flightmanager.service.dto;

import java.util.Date;
import java.util.UUID;

public class FlightDtoView {

    private String idFlight;
    private Date departureDate;
    private Date destinationDate;
    private Double durationTime;
    private String destinationAirport;
    private String locationAirport;
    private int availableSeats;

    public FlightDtoView(UUID idFlight, Date departureDate, Date destinationDate, Double durationTime, String destinationAirport, String locationAirport, int availableSeats) {
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
        this.durationTime = durationTime;
        this.destinationAirport = destinationAirport;
        this.locationAirport = locationAirport;
        this.idFlight = idFlight.toString();
        this.availableSeats = availableSeats;
    }

    public String getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
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

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getLocationAirport() {
        return locationAirport;
    }

    public void setLocationAirport(String locationAirport) {
        this.locationAirport = locationAirport;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
