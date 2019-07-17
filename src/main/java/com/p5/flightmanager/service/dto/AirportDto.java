package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Flight;

import java.util.List;

public class AirportDto {

    private String id;
    private String name;
    private String city;
    private String country;
    private Integer terminals;
    private String code;
    private Integer timezoneOffset;
    private List<FlightDto> flightList;

    public List<FlightDto> getFlightList() { return flightList; }

    public void setFlightList(List<FlightDto> flightList) { this.flightList = flightList; }

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

    public Integer getTerminals() {
        return terminals;
    }

    public void setTerminals(Integer terminals) {
        this.terminals = terminals;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }
}
