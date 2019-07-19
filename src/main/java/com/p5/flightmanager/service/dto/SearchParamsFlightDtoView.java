package com.p5.flightmanager.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SearchParamsFlightDtoView {

    @NotNull
    @NotBlank
    private String destinationAirportId;

    @NotNull
    @NotBlank
    private String locationAirportId;

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
