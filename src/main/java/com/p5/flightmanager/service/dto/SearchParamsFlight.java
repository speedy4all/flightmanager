package com.p5.flightmanager.service.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SearchParamsFlight {

    private String destinationAirportId;

    private String locationAirportId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date departureDate;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
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
