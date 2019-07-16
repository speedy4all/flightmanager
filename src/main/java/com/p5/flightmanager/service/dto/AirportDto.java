package com.p5.flightmanager.service.dto;

import javax.persistence.Id;
import java.util.UUID;

public class AirportDto {
    private UUID Id;
    private String Country;
    private Double Offset;
    private Double FlightsAvailable;
    private String Location;
    private String Name;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Double getOffset() {
        return Offset;
    }

    public void setOffset(Double offset) {
        Offset = offset;
    }

    public Double getFlightsAvailable() {
        return FlightsAvailable;
    }

    public void setFlightsAvailable(Double flightsAvailable) {
        FlightsAvailable = flightsAvailable;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
