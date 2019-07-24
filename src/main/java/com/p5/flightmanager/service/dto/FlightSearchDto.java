package com.p5.flightmanager.service.dto;



import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;



import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;

import java.util.UUID;



public class FlightSearchDto implements Serializable {



    private String idDeparture;

    private String idDestination;



    //@JsonFormat(iso = DateTimeFormat.ISO.DATE)

    private Date departureDate;



    public String getIdDeparture() {

        return idDeparture;

    }



    public void setIdDeparture(String idDeparture) {

        this.idDeparture = idDeparture;

    }



    public String getIdDestination() {

        return idDestination;

    }



    public void setIdDestination(String idDestination) {

        this.idDestination = idDestination;

    }



    public Date getDepartureDate() {

        return departureDate;

    }



    public void setDepartureDate(Date departureDate) {

        this.departureDate = departureDate;

    }

}