package com.p5.flightmanager.service.dto;



import com.p5.flightmanager.repository.models.Airport;



import java.util.ArrayList;

import java.util.Date;

import java.util.List;



public class FlightDto {



    private String id;

    private String name;

    private AirportDto departureAirport;

    private AirportDto destinationAirport;

    private Double durationTime;

    private Date departureDate;

    private Date destinationDate;

    private String fullFlightDescription;

    private FlightType flightType;

    private List<PassengerDto> passengerDtos = new ArrayList<>();

    private PlaneDto planeDto;



    public PlaneDto getPlaneDto() { return planeDto; }



    public void setPlaneDto(PlaneDto planeDto) { this.planeDto = planeDto; }



    public FlightType getFlightType() {

        return flightType;

    }



    public void setFlightType(FlightType flightType) {

        this.flightType = flightType;

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



    public AirportDto getDepartureAirport() { return departureAirport; }



    public void setDepartureAirport(AirportDto departureAirport) { this.departureAirport = departureAirport; }



    public AirportDto getDestinationAirport() { return destinationAirport; }



    public void setDestinationAirport(AirportDto destinationAirport) { this.destinationAirport = destinationAirport; }



    public String getFullFlightDescription() {

        return fullFlightDescription;

    }



    public void setFullFlightDescription(String fullFlightDescription) { this.fullFlightDescription = fullFlightDescription; }



    public Double getDurationTime() {

        return durationTime;

    }



    public void setDurationTime(Double durationTime) {

        this.durationTime = durationTime;

    }



    public Date getDepartureDate() {

        return departureDate;

    }



    public void setDepartureDate(Date departureDate) {

        this.departureDate = departureDate;

    }



    public Date getDestinationDate() {

        return destinationDate;

    }



    public void setDestinationDate(Date destinationDate) {

        this.destinationDate = destinationDate;

    }



    public List<PassengerDto> getPassengerDtos() {

        return passengerDtos;

    }



    public void setPassengerDtos(List<PassengerDto> passengerDtos) {

        this.passengerDtos = passengerDtos;

    }

}