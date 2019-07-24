package com.p5.flightmanager.service.dto;



import java.util.Date;

import java.util.UUID;



public class FlightSimpleDto {



    private String departureAirportCode;

    private String destinationAirportCode;



    private String departureAirportName;

    private String destinationAirportName;



    private Date departureDate;

    private Date destinationDate;



    private UUID departureId;

    private UUID destinationId;



    private FlightType flightType;



    public FlightSimpleDto() {



    }



    public FlightSimpleDto(String departureAirportCode, String destinationAirportCode, String departureAirportName, String destinationAirportName, Date departureDate, Date destinationDate, UUID departureId, UUID destinationId, FlightType flightType) {

        this.departureAirportCode = departureAirportCode;

        this.destinationAirportCode = destinationAirportCode;

        this.departureAirportName = departureAirportName;

        this.destinationAirportName = destinationAirportName;

        this.departureDate = departureDate;

        this.destinationDate = destinationDate;

        this.departureId = departureId;

        this.destinationId = destinationId;

        this.flightType = flightType;

    }



    public UUID getDepartureId() {

        return departureId;

    }



    public void setDepartureId(UUID departureId) {

        this.departureId = departureId;

    }



    public UUID getDestinationId() {

        return destinationId;

    }



    public void setDestinationId(UUID destinationId) {

        this.destinationId = destinationId;

    }



    public String getDepartureAirportCode() {

        return departureAirportCode;

    }



    public void setDepartureAirportCode(String departureAirportCode) {

        this.departureAirportCode = departureAirportCode;

    }



    public String getDestinationAirportCode() {

        return destinationAirportCode;

    }



    public void setDestinationAirportCode(String destinationAirportCode) {

        this.destinationAirportCode = destinationAirportCode;

    }



    public FlightType getFlightType() {

        return flightType;

    }



    public void setFlightType(FlightType flightType) {

        this.flightType = flightType;

    }



    public Date getDepartureDate() { return departureDate; }



    public void setDepartureDate(Date departureDate) { this.departureDate = departureDate; }



    public Date getDestinationDate() { return destinationDate; }



    public void setDestinationDate(Date destinationDate) { this.destinationDate = destinationDate; }



    public String getDepartureAirportName() {

        return departureAirportName;

    }



    public void setDepartureAirportName(String departureAirportName) {

        this.departureAirportName = departureAirportName;

    }



    public String getDestinationAirportName() {

        return destinationAirportName;

    }



    public void setDestinationAirportName(String destinationAirportName) {

        this.destinationAirportName = destinationAirportName;

    }

}