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

    @Column(name = "terminals")
    @Type(type = "integer")
    private Integer terminals;

    @Column(name = "city")
    @Type(type = "string")
    private String city;

    @Column(name = "country")
    @Type(type = "string")
    private String country;

    @Column(name = "code")
    @Type(type = "string")
    private String code;

    @Column(name = "timezone_offset")
    @Type(type = "integer")
    private Integer timezoneOffset;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Flight.class)
    @JoinTable(name = "T_AIRPORT_FLIGHT",
            joinColumns = { @JoinColumn(name = "airport_id", nullable = false, foreignKey = @ForeignKey(name = "fk_airport_flight"))},
            inverseJoinColumns = { @JoinColumn(name = "flight_id", nullable = false, foreignKey = @ForeignKey(name = "fk_flight_airport"))},
            uniqueConstraints = { @UniqueConstraint(columnNames = {"airport_id", "flight_id"}, name = "uk_airport_flight")},
            indexes = { @Index(columnList = "flight_id", name = "ix_airport_flight")})
    private List<Flight> flightList = new ArrayList<>();

    public Airport() {
        // default constructor
    }

    public Airport(String name, Integer terminals, String city, String country, String code, Integer timezoneOffset) {
        this.name = name;
        this.terminals = terminals;
        this.city = city;
        this.country = country;
        this.code = code;
        this.timezoneOffset = timezoneOffset;
    }

    public Airport(Airport airport) {
        super(airport);
        this.name = airport.name;
        this.terminals = airport.terminals;
        this.city = airport.city;
        this.country = airport.country;
        this.code = airport.code;
        this.timezoneOffset = airport.timezoneOffset;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
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

    public Integer getTerminals() {
        return terminals;
    }

    public void setTerminals(Integer terminal) {
        this.terminals = terminal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }
}

