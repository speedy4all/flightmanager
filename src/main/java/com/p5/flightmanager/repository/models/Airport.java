package com.p5.flightmanager.repository.models;

import com.sun.scenario.effect.Offset;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "T_Airports")
public class Airport extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    public Airport() {
        //default constructor
    }

    public Airport(String name, String location, Double flightsAvailable, Double offset, String country) {
        this.Name = name;
        this.Location = location;
        this.FlightsAvailable =flightsAvailable;
        this.Offset = offset;
        this.Country = country;

    }

    public Airport(Airport source) {
        super(source);
        this.Name = source.Name;
        this.Location = source.Location;
        this.FlightsAvailable = source.FlightsAvailable;
        this.Offset = source.Offset;
        this.Country = source.Country;
    }



    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    @Column(name = "id", updatable = false, unique = true)
    private UUID Id;

    @Column(name = "name")
    @Type(type = "string")
    private String Name;

    @Column(name = "location")
    @Type(type = "string")
    private String Location;


    @Column(name = "flightsavailable")
    @Type(type = "double")
    private Double FlightsAvailable;

    @Column(name = "offset")
    @Type(type = "double")
    private Double Offset;


    @Column(name = "country")
    @Type(type = "string")
    private String Country;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public UUID getId() {
        return Id;
    }

    @Override
    public void setId(UUID id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Double getFlightsAvailable() {
        return FlightsAvailable;
    }

    public void setFlightsAvailable(Double flightsAvailable) {
        FlightsAvailable = flightsAvailable;
    }

    public Double getOffset() {
        return Offset;
    }

    public void setOffset(Double offset) {
        Offset = offset;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}





