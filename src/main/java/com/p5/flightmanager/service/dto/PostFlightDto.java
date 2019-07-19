package com.p5.flightmanager.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostFlightDto {

    private String id;
    private String name;
    private Date departureDate;
    private Date destinationDate;
    private Double durationTime;
    private String fullFlightDescription;
    private FlightType flightType;
    @NotNull
    @NotBlank
    private String planeId;
    @NotNull
    @NotBlank
    private String destinationAirportId;
    @NotNull
    @NotBlank
    private String locationAirportId;

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

    public String getFullFlightDescription() {
        return fullFlightDescription;
    }

    public void setFullFlightDescription(String fullFlightDescription) {
        this.fullFlightDescription = fullFlightDescription;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public String getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(String destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public String getLocationAirportId() {
        return locationAirportId;
    }

    public void setLocationAirportId(String locationAirportId) {
        this.locationAirportId = locationAirportId;
    }
}
