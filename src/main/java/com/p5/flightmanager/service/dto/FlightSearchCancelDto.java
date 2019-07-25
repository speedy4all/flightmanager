package com.p5.flightmanager.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class FlightSearchCancelDto {

    @NotBlank
    @NotNull
    private UUID flightId;

    @NotBlank
    @NotNull
    private UUID uniqueIdentifier;

    public FlightSearchCancelDto(@NotNull UUID flightId, @NotNull UUID uniqueIdentifier) {
        this.flightId = flightId;
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public UUID getFlightId() {
        return flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
    }

    public UUID getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(UUID uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
