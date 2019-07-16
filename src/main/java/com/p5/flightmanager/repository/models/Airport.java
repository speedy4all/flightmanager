package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_AIRPORT")
public class Airport extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    public Airport(){
        //default constructor
    }

    public Airport(String name, String location, String identificationCode, Integer numberOfTerminals, Integer timezoneOffset) {
        this.name = name;
        this.location = location;
        this.identificationCode = identificationCode;
        this.numberOfTerminals = numberOfTerminals;
        this.timezoneOffset = timezoneOffset;
    }

    public Airport(BaseModel source, String name, String location, String identificationCode, Integer numberOfTerminals, Integer timezoneOffset) {
        super(source);
        this.name = name;
        this.location = location;
        this.identificationCode = identificationCode;
        this.numberOfTerminals = numberOfTerminals;
        this.timezoneOffset = timezoneOffset;
    }

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "location")
    @Type(type = "string")
    private String location;

    @Column(name = "identification_code")
    @Type(type = "string")
    private String identificationCode;

    @Column(name = "number_of_terminals")
    @Type(type = "int")
    private Integer numberOfTerminals;

    @Column(name = "timezone_offset")
    @Type(type = "int")
    private Integer timezoneOffset;

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

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public Integer getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(Integer numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }
}
