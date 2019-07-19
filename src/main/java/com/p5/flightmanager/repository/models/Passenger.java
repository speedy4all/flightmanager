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

    @Column(name = "last_name")
    @Type(type = "string")
    private String lastName;

    @Column(name = "country")
    @Type(type = "string")
    private String country;

    @Column(name = "birthday_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdayDate;

    @Column(name = "sex")
    @Type(type = "string")
    private String sex;

    @Column(name = "identify_number")
    @Type(type = "string")
    private String identifyNumber;

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

    public Passenger(String firstName, String lastName, String sex, String identifyNumber, String country, Date birthdayDate, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
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
        this.lastName = source.lastName;
        this.sex = source.sex;
        this.identifyNumber = source.identifyNumber;
        this.country = source.country;
        this.birthdayDate = source.birthdayDate;
        this.email = source.email;
        this.phoneNumber = source.phoneNumber;
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

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
}
