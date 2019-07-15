package com.p5.flightmanager.service.dto;

import java.util.Date;

public class PassengerDto {

        private String id;
        private String name;
        private String surname;
        private String fullname;
        private String nationality;
        private Integer age;
        private String gender;
        private Double phonenumber;
        private String emailadress;
        private Double personalidentifier;
        private Date birthdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Double phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }

    public Double getPersonalidentifier() {
        return personalidentifier;
    }

    public void setPersonalidentifier(Double personalidentifier) {
        this.personalidentifier = personalidentifier;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
