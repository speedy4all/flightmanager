package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_AIRPORT")
public class Airport extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "city")
    @Type(type = "string")
    private String city;

    @Column(name = "country")
    @Type(type = "string")
    private String country;

    @Column(name = "off_set")
    @Type(type = "int")
    private Integer offSet;

    @Column(name = "iata")
    @Type(type = "string")
    private String iata;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Flight.class)
    @JoinTable(name = "T_AIRPORT_FLIGHT",
            joinColumns = {@JoinColumn(name = "airport_id", nullable = false, foreignKey = @ForeignKey(name = "fk_airport_flight"))},
            inverseJoinColumns = {@JoinColumn(name = "flight_id", nullable = false, foreignKey = @ForeignKey(name = "fk_flight_airport"))},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"flight_id", "airport_id"}, name = "uk_airport_flight")},
            indexes = {@Index(columnList = "flight_id", name = "ix_airport_flight")})
    List<Flight> flights = new ArrayList();

    public Airport() {
        //default constructor
    }

    public Airport(String name, String city, String country, Integer offSet, String IATA) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.offSet = offSet;
        this.iata = IATA;
    }

    public Airport(Airport source) {
        super(source);
        this.name = source.name;
        this.city = source.city;
        this.country = source.country;
        this.offSet = source.offSet;
        this.iata = source.iata;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getOffSet() {
        return offSet;
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

}
