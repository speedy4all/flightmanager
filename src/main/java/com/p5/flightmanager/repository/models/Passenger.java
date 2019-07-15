package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name = "T_Passenger")

public class Passenger extends BaseModel implements Serializable {

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "identify_number")
    @Type(type = "string")
    private String identify_number;

    @Column(name = "phoneNumber")
    @Type(type = "string")
    private String phoneNumber;

    @Column(name = "flightNumber")
    @Type(type = "double")
    private Double flightNumber;

    @Column(name = "birthDate")
    @Type(type = "date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "homeAdress")
    @Type(type = "string")
    private String homeAdress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentify_number() {
        return identify_number;
    }

    public void setIdentify_number(String identify_number) {
        this.identify_number = identify_number;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Double flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }


    public Passenger(String name, String identify_number, String phoneNumber, Double flightNumber, Date birthDate, String homeAdress) {
        this.name = name;
        this.identify_number = identify_number;
        this.phoneNumber = phoneNumber;
        this.flightNumber = flightNumber;
        this.birthDate = birthDate;
        this.homeAdress = homeAdress;
    }

    public Passenger( Passenger source) {
        super(source);
        this.name = source.name;
        this.identify_number = source.identify_number;
        this.phoneNumber = source.phoneNumber;
        this.flightNumber = source.flightNumber;
        this.birthDate = source.birthDate;
        this.homeAdress = source.homeAdress;
    }
}
