package com.p5.flightmanager.service.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class FlightParamsDto {

    private UUID idDeparture;
    private UUID idDestination;
    private Date departureDate;

    public UUID getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(UUID idDeparture) {
        this.idDeparture = idDeparture;
    }

    public UUID getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(UUID idDestination) {
        this.idDestination = idDestination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
