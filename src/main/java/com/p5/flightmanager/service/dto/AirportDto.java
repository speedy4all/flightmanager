package com.p5.flightmanager.service.dto;

import java.util.ArrayList;
import java.util.List;

public class AirportDto {

    private String id;
    private String name;
    private String city;
    private String country;
    private Integer offSet;
    private String IATA;
    private List<FlightDto> flightsList = new ArrayList<>();

    public List<FlightDto> getFlightsList() {
        return flightsList;
    }

    public void setFlightsList(List<FlightDto> flightsList) {
        this.flightsList = flightsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getOffSet() {
        return offSet;
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }
}
