package com.p5.flightmanager.service.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class FlightCancelDto {

    @NotNull
    private UUID flightId;

    @NotNull
    private UUID uniqueIdentifier;


}
