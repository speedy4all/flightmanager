package com.p5.flightmanager.Repository.Models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "T_FLIGHT")
public class Flight<String extends Serializable> implements Serializable {

    private static final long  serialVersionUID = 1L;

    public Flight(){
    }

    public Flight(String name, String departureLocation, String destinationLocation, Double durationTime, Date departureDare, Date destinationDate) {
        this.name = name;
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
        this.durationTime = durationTime;
        this.departureDare = departureDare;
        this.destinationDate = destinationDate;
    }

    @Id
    @GenericGenerator(name= "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    @Column(name = "id", updatable = false, unique = true)
    private UUID id;

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "departure_location")
    @Type(type = "string")
    private String departureLocation;

    @Column(name = "destination_location")
    @Type(type = "string")
    private String destinationLocation;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "duration_time")
    @Type(type = "double")
    private Double durationTime;

    @Column(name = "departure_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDare;

    @Column(name = "destination_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date destinationDate;



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

    public Double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Double durationTime) {
        this.durationTime = durationTime;
    }

    public Date getDepartureDare() {
        return departureDare;
    }

    public void setDepartureDare(Date departureDare) {
        this.departureDare = departureDare;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }
}
