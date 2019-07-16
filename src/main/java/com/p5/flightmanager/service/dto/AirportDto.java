package com.p5.flightmanager.service.dto;

public class AirportDto {

    public String id;
    public String name;
    public String location;
    public String identificationNumber;
    public Integer offset;
    public Integer terminals;
    private String fullDescription;

    public String getId() {
        return id;
    }

    public Integer getTerminals() {
        return terminals;
    }

    public void setTerminals(Integer terminals) {
        this.terminals = terminals;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getFullFlightDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
