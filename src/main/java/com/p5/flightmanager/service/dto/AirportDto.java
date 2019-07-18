package com.p5.flightmanager.service.dto;

import java.util.ArrayList;
import java.util.List;

public class AirportDto  {

    private String id;
    private int terminals;
    private String name;
    private String code;
    private String location;
    private int offset;
    private double length;
    private int altitude;
    private List<FlightDto> flights = new ArrayList<>();

    public AirportDto() {
    }

    public AirportDto(String id, String name, String location) {
        this.id = id;
        this.location = location;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTerminals() {
        return terminals;
    }

    public void setTerminals(int terminals) {
        this.terminals = terminals;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public List<FlightDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDto> flights) {
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
