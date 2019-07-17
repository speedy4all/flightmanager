package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "T_AIRPORT")
public class Airport extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column(name = "name")
    @Type(type = "string")
    public String name;

    @Column(name = "location")
    @Type(type = "string")
    public String location;

    @Column(name = "identification_number")
    @Type(type = "string")
    public String identificationNumber;

    @Column(name = "timezone_offset")
    @Type(type = "integer")
    public Integer offset;

    @Column(name = "terminals")
    @Type(type = "integer")
    public Integer terminals;

    public Airport() {
        // default constructor
    }

    public Airport(String name, String location, String identificationNumber, Integer offset) {
        this.name = name;
        this.location = location;
        this.identificationNumber = identificationNumber;
        this.offset = offset;
    }

    public Airport(BaseModel source) {
        super(source);
        this.name = name;
        this.location = location;
        this.identificationNumber = identificationNumber;
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTerminals() { return terminals; }

    public void setTerminals(Integer terminals) { this.terminals = terminals; }
}
