package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_PASSENGER")
public class Passenger extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    public Passenger(){
        //default constructor
    }

    public Passenger(BaseModel source, String firstName, String lastName, String gender, String email, String mobileNumber, Date dateOfBirth, String personalIdentificationCode, String language) {
        super(source);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.personalIdentificationCode = personalIdentificationCode;
        this.language = language;
    }

    public Passenger(String firstName, String lastName, String gender, String email, String mobileNumber, Date dateOfBirth, String personalIdentificationCode, String language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.personalIdentificationCode = personalIdentificationCode;
        this.language = language;
    }

    @Column(name = "first_name")
    @Type(type = "string")
    private String firstName;

    @Column(name = "last_name")
    @Type(type = "string")
    private String lastName;

    @Column(name = "gender")
    @Type(type = "string")
    private String gender;

    @Column(name = "email")
    @Type(type = "string")
    private String email;

    @Column(name = "mobile_number")
    @Type(type = "string")
    private String mobileNumber;

    @Column(name = "date_of_birth")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Column(name = "personal_identification_code")
    @Type(type = "string")
    private String personalIdentificationCode;

    @Column(name = "language")
    @Type(type = "string")
    private String language;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPersonalIdentificationCode() {
        return personalIdentificationCode;
    }

    public void setPersonalIdentifierCode(String personalIdentificationCode) {
        this.personalIdentificationCode = personalIdentificationCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
