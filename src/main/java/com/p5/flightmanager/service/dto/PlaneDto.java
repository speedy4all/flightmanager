package com.p5.flightmanager.service.dto;



public class PlaneDto {



    private String id;

    private String model;

    private Integer seats;

    private String companyName;

    private String code;



    public String getId() {

        return id;

    }



    public void setId(String id) {

        this.id = id;

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