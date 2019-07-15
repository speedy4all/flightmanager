package com.p5.flightmanager.service.dto;

import java.util.Date;

public class PassengerDto {

    private Date birthDate;
    private String name;
    private String homeAdress;

    private String phoneNumber;
    private String identify_number;
    private Double flightNumber;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentify_number() {
        return identify_number;
    }

    public void setIdentify_number(String identify_number) {
        this.identify_number = identify_number;
    }

    public Double getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Double flightNumber) {
        this.flightNumber = flightNumber;
    }

    public PassengerDto(Date birthDate, String name, String homeAdress, String phoneNumber, String identify_number, Double flightNumber) {
        this.birthDate = birthDate;
        this.name = name;
        this.homeAdress = homeAdress;
        this.phoneNumber = phoneNumber;
        this.identify_number = identify_number;
        this.flightNumber = flightNumber;



    }
    public PassengerDto(){

    }
}
