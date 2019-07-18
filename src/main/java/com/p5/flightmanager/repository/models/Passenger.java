package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_PASSENGER")
public class Passenger extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column(name = "first_name")
    @Type(type = "string")
    private String firstName;

    @Column(name = "second_name")
    @Type(type = "string")
    private String secondName;

    @Column(name = "age")
    @Type(type = "integer")
    private Integer age;

    @Column(name = "sex")
    @Type(type = "string")
    private String sex;

    @Column(name = "identify_number")
    @Type(type = "string")
    private String identifyNumber;

    @Column(name = "country")
    @Type(type = "string")
    private String country;

    @Column(name = "birthday_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdayDate;

    @Column(name = "email")
    @Type(type = "string")
    @Temporal(TemporalType.TIMESTAMP)
    private String email;

    @Column(name = "phone_number")
    @Type(type = "string")
    private String phoneNumber;

    public Passenger() {
        //default constructor
    }

    public Passenger(String firstName, String secondName, Integer age, String sex, String identifyNumber, String country, Date birthdayDate, String email, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.sex = sex;
        this.identifyNumber = identifyNumber;
        this.country = country;
        this.birthdayDate = birthdayDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Passenger(Passenger source) {
        super(source);
        this.firstName = source.firstName;
        this.secondName = source.secondName;
        this.age = source.age;
        this.sex = source.sex;
        this.identifyNumber = source.identifyNumber;
        this.country = source.country;
        this.birthdayDate = source.birthdayDate;
        this.email = source.email;
        this.phoneNumber = source.phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}
