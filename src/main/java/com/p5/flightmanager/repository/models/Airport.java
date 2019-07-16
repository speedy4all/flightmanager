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

    public Airport(Airport airport){
        super(airport);
        this.name = airport.name;
        this.terminals = airport.terminals;
        this.city = airport.city;
        this.country = airport.country;
        this.code = airport.code;
        this.timezoneOffset = airport.timezoneOffset;
    }

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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

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

    public Integer getTimezoneOffset() { return timezoneOffset; }

    public void setTimezoneOffset(Integer timezoneOffset) { this.timezoneOffset = timezoneOffset; }
}

//  Airport
//        -terminals
//        -location
//        -code (airport code)
//        -fus orar (offset) (Timezone -> String, sau Integer (180, 300 min))