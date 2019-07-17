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
