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

    @Column
    @Type(type = "integer")
    int terminals;

    @Column
    @Type(type = "string")
    String name;

    @Column
    @Type(type = "string")
    String code;

    @Column
    @Type(type = "string")
    String location;

    @Column(name = "off_set")
    @Type(type = "integer")
    int offset;

    @Column
    @Type(type = "double")
    double length;

    @Column
    @Type(type = "integer")
    int altitude;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Flight.class)
            @JoinTable(name = "T_AIRPORT_FLIGHT",
                    joinColumns = {@JoinColumn(name = "airport_id", nullable = false, foreignKey = @ForeignKey(name = "fk_airport_flight"))},
                    inverseJoinColumns = {@JoinColumn(name = "flight_id", nullable = false, foreignKey = @ForeignKey(name = "fk_flight_airport"))},
                    uniqueConstraints = { @UniqueConstraint(columnNames = {"flight_id", "airport_id"}, name = "uk_airport_flight")},
                    indexes = { @Index(columnList = "flight_id", name = "ix_airport_flight")})
    List<Flight> flights = new ArrayList();

    public Airport(int terminals, String code, String location, int offset, double length, int altitude) {
        this.terminals = terminals;
        this.code = code;
        this.location = location;
        this.offset = offset;
        this.length = length;
        this.altitude = altitude;
    }

    public Airport() {
        //empty constructor
    }

    public Airport(Airport source) {
        super(source);
        this.terminals = source.terminals;
        this.code = source.code;
        this.location = source.location;
        this.offset = source.offset;
        this.length = source.length;
        this.altitude = source.altitude;
    }

    public int getTerminals() {
        return terminals;
    }

    public void setTerminals(int terminals) {
        this.terminals = terminals;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
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
}
