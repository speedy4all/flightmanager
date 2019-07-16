package com.p5.flightmanager.repository.models;

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
        //default constructor
    }

    public Plane(String model, Integer numberOfSeats) {
        this.model = model;
        this.numberOfSeats = numberOfSeats;
    }

    public Plane(Plane source) {
        super(source);
        this.model = source.model;
        this.numberOfSeats = source.numberOfSeats;
    }

    @Column(name = "plane_model")
    @Type(type = "string")
    private String model;

    @Column(name = "number_of_seats")
    @Type(type = "integer")
    private Integer numberOfSeats;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
