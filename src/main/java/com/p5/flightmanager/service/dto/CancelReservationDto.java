package com.p5.flightmanager.service.dto;

import java.util.UUID;

public class CancelReservationDto {
    private UUID flightId;
    private String identifyNumber;

    public UUID getFlightId() {
        return flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }
}
