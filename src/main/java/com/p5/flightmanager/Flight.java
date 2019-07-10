package com.p5.flightmanager;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_FLIGHT")
public class Flight<String extends Serializable> implements Serializable {

    public static final long serialVersionUID = 1L;

    public Flight() {
    }

    public Flight(String id, String name, String departureLocation, Date departureDate, String destinationLocation, Date destinationDate, Double durationTime) {
        this.id = id;
        this.name = name;
        this.departureLocation = departureLocation;
        this.departureDate = departureDate;
        this.destinationLocation = destinationLocation;
        this.destinationDate = destinationDate;
        this.durationTime = durationTime;
    }

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    private String id;

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "departure_location")
    @Type(type = "string")
    private String departureLocation;

    @Column(name = "departure_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @Column(name = "destination_location")
    @Type(type = "string")
    private String destinationLocation;

    @Column(name = "destination_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date destinationDate;

    @Column(name = "duration_time")
    @Type(type = "double")
    private Double durationTime;

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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }

    public Double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Double durationTime) {
        this.durationTime = durationTime;
    }
}
