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

    public Passenger(String firstName, String lastName, String personalID, String email, String phoneNumber, String nationality, Date bornDate, Date destinationDate, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.bornDate = bornDate;
        this.destinationDate = destinationDate;
        this.title = title;
    }

    public Passenger(Passenger source) {
        super(source);
        this.firstName = source.firstName;
        this.lastName = source.lastName;
        this.personalID = source.personalID;
        this.email = source.email;
        this.phoneNumber = source.phoneNumber;
        this.nationality = source.nationality;
        this.bornDate = source.bornDate;
        this.destinationDate = source.destinationDate;
        this.title = source.title;
    }

    @Column(name = "first_name")
    @Type(type = "string")
    private String firstName;

    @Column(name = "last_name")
    @Type(type = "string")
    private String lastName;

    @Column(name = "personal_ID")
    @Type(type = "string")
    private String personalID;

    @Column(name = "email")
    @Type(type = "string")
    private String email;

    @Column(name = "phone_number")
    @Type(type = "string")
    private String phoneNumber;

    @Column(name = "nationality")
    @Type(type = "string")
    private String nationality;

    @Column(name = "date_Born")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bornDate;

    @Column(name = "destination_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date destinationDate;

    @Column(name = "title")
    @Type(type = "string")
    private String title;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getpersonalID() {
        return personalID;
    }

    public void setpersonalID(String personalID) {
        this.personalID = personalID;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}



