package com.p5.flightmanager.service.dto;

import java.util.UUID;

public class AirportDtoSimple {
    private String name;
    private String city;
    private String iata;

    public AirportDtoSimple(){

    }

    public AirportDtoSimple(String name, String iata, String city) {
        this.name = name;
        this.iata = iata;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
}
