package com.p5.flightmanager.service.dto;

import java.util.UUID;

public class AirportSimpleDto {
    private UUID id;
    private String name;
    private String iata;

    public AirportSimpleDto(){

    }
    public AirportSimpleDto(UUID id, String name, String iata) {
        this.name = name;
        this.iata = iata;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
}

