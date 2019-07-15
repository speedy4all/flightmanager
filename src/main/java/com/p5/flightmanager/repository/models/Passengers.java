package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "P_FLIGHT")
public class Passengers implements Serializable {

    public static final long serialVersionUID = 1L;

    public Passengers() {
        //default constructor
    }

    public Passengers(String name, String surname, String fullname, String nationality, Integer age, String gender,Double phonenumber,String emailadress,Double personalidentifier,Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.fullname = fullname;
        this.nationality = nationality;
        this.age = age;
        this.gender = gender;
        this.phonenumber=phonenumber;
        this.emailadress=emailadress;
        this.personalidentifier=personalidentifier;
        this.birthdate=birthdate;
    }

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    @Column(name = "id", updatable = false, unique = true)
    private UUID id;

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "surname")
    @Type(type = "string")
    private String surname;

    @Column(name = "fullname")
    @Type(type = "string")
    private String fullname;

    @Column(name = "nationality")
    @Type(type = "string")
    private String nationality;

    @Column(name = "age")
    @Type(type = "integer")
    private Integer age;

    @Column(name = "gender")
    @Type(type = "string")
    private String gender;

    @Column(name = "phonenumber")
    @Type(type = "double")
    private Double phonenumber;

    @Column(name = "emailadress")
    @Type(type = "string")
    private String emailadress;

    @Column(name = "personalidentifier")
    @Type(type = "double")
    private Double personalidentifier;

    @Column(name = "birthdate")
    @Type(type = "date")
    @Temporal (TemporalType.TIMESTAMP)
    private Date birthdate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
