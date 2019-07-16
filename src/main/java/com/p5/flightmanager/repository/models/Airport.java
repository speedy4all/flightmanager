package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "T_AIRPORT")

public class Airport extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    public Airport() {
    }

    public Airport(String name, String code, String location, String type, int offset) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.type = type;
        this.offset = offset;
    }

    public Airport(BaseModel source, String name, String code, String location, String type, int offset) {
        super(source);
        this.name = name;
        this.code = code;
        this.location = location;
        this.type = type;
        this.offset = offset;
    }

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "code")
    @Type(type = "string")
    private String code;

    @Column(name = "code")
    @Type(type = "string")
    private String location;

    @Column(name = "type")
    @Type(type = "int")
    private String type;

    @Column(name = "off_set")
    @Type(type = "int")
    private int offset;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
