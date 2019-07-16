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
        // default constructor
    }

    public Passenger(String firstName, String lastName, String gender, String email, String mobileNumber, Date dateOfBirth, String identificationCardNumber, Date issueDate, String nationality, String language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.identificationCardNumber = identificationCardNumber;
        this.issueDate = issueDate;
        this.nationality = nationality;
        this.language = language;
    }

    public Passenger(Passenger source) {
        super(source);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.identificationCardNumber = identificationCardNumber;
        this.issueDate = issueDate;
        this.nationality = nationality;
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

    @Column(name = "identification_card_number")
    @Type(type = "string")
    private String identificationCardNumber;

    @Column(name = "issue_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name = "nationality")
    @Type(type = "string")
    private String nationality;

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

    public String getIdentificationCardNumber() {
        return identificationCardNumber;
    }

    public void setIdentificationCardNumber(String identificationCardNumber) {
        this.identificationCardNumber = identificationCardNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
