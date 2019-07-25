package com.p5.flightmanager.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlightSearchCancelDto {

    @NotBlank
    @NotNull
    private String flightId;

    @NotBlank
    @NotNull
    private String identifier;

    public FlightSearchCancelDto(@NotNull String flightId, @NotNull String uniqueIdentifier) {
        this.flightId = flightId;
        this.identifier = uniqueIdentifier;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
