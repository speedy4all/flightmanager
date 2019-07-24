package com.p5.flightmanager.repository.models;

import com.p5.flightmanager.service.dto.TitlePassenger;
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

    @Column(name = "personal_id")
    @Type(type = "string")
    private String personalId;

    @Column(name = "email")
    @Type(type = "string")
    private String email;

    @Column(name = "phone_number")
    @Type(type = "string")
    private String phoneNumber;

    @Column(name = "nationality")
    @Type(type = "string")
    private String nationality;

    @Column(name = "date_born")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bornDate;

    @Column(name = "title")
    @Enumerated(EnumType.STRING)
    private TitlePassenger title;

    public Passenger() {
        //default constructor
    }

    public Passenger(String firstName, String lastName, String personalId, String email, String phoneNumber, String nationality, Date bornDate, TitlePassenger title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.bornDate = bornDate;
        this.title = title;
    }

    public Passenger(Passenger source) {
        super(source);
        this.firstName = source.firstName;
        this.lastName = source.lastName;
        this.personalId = source.personalId;
        this.email = source.email;
        this.phoneNumber = source.phoneNumber;
        this.nationality = source.nationality;
        this.bornDate = source.bornDate;
        this.title = source.title;
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

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalID) {
        this.personalId = personalID;
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

    public TitlePassenger getTitle() {
        return title;
    }

    public void setTitle(TitlePassenger title) {
        this.title = title;
    }
    
}



