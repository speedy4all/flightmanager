package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_PLANE")
public class Plane extends BaseModel implements Serializable {
    //model, nr locuri,

    @Column
    @Type(type = "string")
    String model;

    @Column
    @Type(type = "integer")
    int seats;

    @Column
    @Type(type = "string")
    String name;

    @Column
    @Type(type = "string")
    String code;

    public Plane() {
        //default constructor
    }

    public Plane(String model, int seats, String name, String code) {
        this.model = model;
        this.seats = seats;
        this.name = name;
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

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
}
