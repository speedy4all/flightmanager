package com.p5.flightmanager.service.dto;

import java.io.Serializable;

public class CancelReservationDto implements Serializable {

    private String flightId;
    private String identifier;

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
