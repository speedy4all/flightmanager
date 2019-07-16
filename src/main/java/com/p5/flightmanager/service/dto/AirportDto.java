package com.p5.flightmanager.service.dto;

public class AirportDto {

    private String id;
    private String code;
    private String location;
    private Integer utcOffset;
    private String fullAirportDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getFullAirportDetails() {
        return fullAirportDetails;
    }

    public void setFullAirportDetails(String fullAirportDetails) {
        this.fullAirportDetails = fullAirportDetails;
    }
}
