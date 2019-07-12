package com.p5.flightmanager.service.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.p5.flightmanager.repository.models.Flight;

import java.util.UUID;

public class FlightDto {

    private String id;
    private String name;
    private String departureLocation;

    private String destinationLocation;
    private String fullFlightDescription;
    private String departureDate;
    private Double durationTime;

    public Double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Double durationTime) {
        this.durationTime = durationTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
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

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getFullFlightDescription() {
        return fullFlightDescription;
    }

    public void setFullFlightDescription(String fullFlightDescription) {
        this.fullFlightDescription = fullFlightDescription;
    }

    public final static Flight fromDto(FlightDto flightDto){
        Flight flight=new Flight();


        flightDto.setDepartureLocation(flightDto.getDepartureLocation());
        flightDto.setName(flightDto.getName());
        flightDto.setDurationTime(flightDto.getDurationTime());
        flightDto.setDepartureDate(flightDto.getDepartureDate());
        flightDto.setDestinationLocation(flightDto.getDestinationLocation());

        return flight;
    }
    public final static FlightDto toDto(Flight flightDto) {
        FlightDto flight = new FlightDto();
        //flightDto.setId(UUID.fromString(flightDto.getId()));
        flightDto.setName(flightDto.getName());
        flightDto.setDurationTime(flightDto.getDurationTime());
        flightDto.setDepartureDate(flightDto.getDepartureDate());
        flightDto.setDestinationLocation(flightDto.getDestinationLocation());



        return flight;
    }




    }
