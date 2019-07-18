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

    public Airport() {
        //default constructor
    }

    public Airport(String code, String location, Integer utcOffset) {
        this.code = code;
        this.location = location;
        this.utcOffset = utcOffset;
    }

    public Airport(Airport source) {
        super(source);
        this.code = source.code;
        this.location = source.location;
        this.utcOffset = source.utcOffset;
    }

    @Column(name = "airport_code")
    @Type(type = "string")
    private String code;

    @Column(name = "airport_location")
    @Type(type = "string")
    private String location;

    @Column(name = "utc_offest")
    @Type(type = "int")
    private Integer utcOffset;

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

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }
}
