package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_AIRPLANE")
public class Airplane extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    public Airplane(){
        //default constructor
    }

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "number_of_seats")
    @Type(type = "int")
    private Integer numberOfSeats;

    public Airplane(String name, int numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public Airplane(BaseModel source, String name, int numberOfSeats) {
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
