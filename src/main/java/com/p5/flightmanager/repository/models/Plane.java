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



    @Column(name = "model")

    @Type(type = "string")

    private String model;



    @Column(name = "seats")

    @Type(type = "integer")

    private Integer seats;



    @Column(name = "company_name")

    @Type(type = "string")

    private String companyName;



    @Column(name = "code")

    @Type(type = "string")

    private String code;



    public Plane() {

        //default constructor

    }



    public Plane(String model, int seats, String companyName, String code) {

        this.model = model;

        this.seats = seats;

        this.companyName = companyName;

        this.code = code;

    }



    public String getModel() {

        return model;

    }



    public void setModel(String model) {

        this.model = model;

    }



    public Integer getSeats() {

        return seats;

    }



    public void setSeats(Integer seats) {

        this.seats = seats;

    }



    public String getCompanyName() {

        return companyName;

    }



    public void setCompanyName(String companyName) {

        this.companyName = companyName;

    }



    public String getCode() {

        return code;

    }



    public void setCode(String code) {

        this.code = code;

    }

}