package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_PASSENGER")
public class Passenger extends BaseModel implements Serializable {
    public static final long serialVersionUID = 1L;

    public Passenger() {
        //default constructor
    }

    public Passenger(String firstName, String lastName, Date birthdayDate, Integer age, String gender, String cnp, String phoneNumber, String emailAddress, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.age = age;
        this.gender = gender;
        this.cnp = cnp;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
    }

    public Passenger(Passenger source) {
        super(source);
        this.firstName = source.firstName;
        this.lastName = source.lastName;
        this.birthdayDate = source.birthdayDate;
        this.age = source.age;
        this.gender = source.gender;
        this.cnp = source.cnp;
        this.phoneNumber = source.phoneNumber;
        this.emailAddress = source.emailAddress;
        this.nationality = source.nationality;
    }

    @Column(name = "first_name")
    @Type(type = "string")
    private String firstName;

    @Column(name = "last_name")
    @Type(type = "string")
    private String lastName;

    @Column(name = "birthday_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdayDate;

    @Column(name = "age")
    @Type(type = "integer")
    private Integer age;

    @Column(name = "gender")
    @Type(type = "string")
    private String gender;

    @Column(name = "cnp")
    @Type(type = "string")
    private String cnp;

    @Column(name = "phone_number")
    @Type(type = "string")
    private String phoneNumber;

    @Column(name = "email_address")
    @Type(type = "string")
    private String emailAddress;

    @Column(name = "nationality")
    @Type(type = "string")
    private String nationality;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
