package com.p5.flightmanager.service.dto;

public class FlightDto {

    private String id;
    private String name;
    private String deaprtureLocation;
    private String destinationLocation;
    private String fullFlightDescription;

    public String getFullFlightDescription() {
        return fullFlightDescription;
    }

    public void setFullFlightDescription(String fullFlightDescription) {
        this.fullFlightDescription = fullFlightDescription;
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

    public String getDeaprtureLocation() {
        return deaprtureLocation;
    }

    public void setDeaprtureLocation(String deaprtureLocation) {
        this.deaprtureLocation = deaprtureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
}
