package com.p5.flightmanager.service.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class FlightParamsDto {

    @NotNull
    @NotBlank
    private String departureLocation;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date departureDate;

    @NotNull
    @NotBlank
    private String destinationLocation;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date destinationDate;


    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDestinationDate() { return destinationDate; }

    public void setDestinationDate(Date destinationDate) { this.destinationDate = destinationDate; }

    public String getDepartureLocation() { return departureLocation; }

    public void setDepartureLocation(String departureLocation) { this.departureLocation = departureLocation; }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
}
