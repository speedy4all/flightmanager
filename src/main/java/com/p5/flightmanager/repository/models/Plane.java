package com.p5.flightmanager.repository.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_PLANE")
public class Plane extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    public Plane() {
    }

    public Plane(String name, String model, int passengersCapacity, String code, double altitude, double fuelCapacity) {
        this.name = name;
        this.model = model;
        this.passengersCapacity = passengersCapacity;
        this.code = code;
        this.altitude = altitude;
        this.fuelCapacity = fuelCapacity;
    }

    public Plane(BaseModel source, String name, String model, int passengersCapacity, String code, double altitude, double fuelCapacity) {
        super(source);
        this.name = name;
        this.model = model;
        this.passengersCapacity = passengersCapacity;
        this.code = code;
        this.altitude = altitude;
        this.fuelCapacity = fuelCapacity;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "model")
    @Type(type = "string")
    private String model;

    @Column(name = "passengers_capacity")
    @Type(type = "string")
    private int passengersCapacity;

    @Column(name = "code")
    @Type(type = "string")
    private String code;

    @Column(name = "altitude")
    @Type(type = "double")
    private  double altitude;

    @Column(name = "fuelCapacity")
    @Type(type = "double")
    private double fuelCapacity;
}
