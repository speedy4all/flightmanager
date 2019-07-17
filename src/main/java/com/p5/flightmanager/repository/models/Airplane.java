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
@Table(name = "T_AIRPLANE")
public class Airplane extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column(name = "name")
    @Type(type = "string")
    public String name;

    @Column(name = "number_of_seats")
    @Type(type = "int")
    public Integer numberOfSeats;

    public Airplane() {
        // default constructor
    }

    public Airplane(String name, Integer numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public Airplane(BaseModel source) {
        super(source);
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
