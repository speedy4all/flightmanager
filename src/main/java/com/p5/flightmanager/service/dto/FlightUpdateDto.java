package com.p5.flightmanager.service.dto;



import java.io.Serializable;



public class FlightUpdateDto implements Serializable {

    private String flightId;

    private String uniqueIdentifier;

    private String passengerName;



    public String getFlightId() {

        return flightId;

    }



    public void setFlightId(String flightId) {

        this.flightId = flightId;

    }



    public String getUniqueIdentifier() {

        return uniqueIdentifier;

    }



    public void setUniqueIdentifier(String uniqueIdentifier) {

        this.uniqueIdentifier = uniqueIdentifier;

    }



    public String getPassengerName() {

        return passengerName;

    }



    public void setPassengerName(String passengerName) {

        this.passengerName = passengerName;

    }

}