package com.p5.flightmanager.service.dto;



import java.util.Date;



public class PassengerDto {



    private String id;

    private String firstName;

    private String lastName;

    private Date birthdayDate;

    private Integer age;

    private String identifyNumber;

    private String sex;

    private String email;

    private String phoneNumber;

    private String country;



    public String getId() {

        return id;

    }



    public void setId(String id) {

        this.id = id;

    }



    public String getFirstName() {

        return firstName;

    }



    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }



    public String getLastName() { return lastName; }



    public void setLastName(String lastName) { this.lastName = lastName; }



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



    public Date getBirthdayDate() {

        return birthdayDate;

    }



    public void setBirthdayDate(Date birthDate) {

        this.birthdayDate = birthDate;

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



    public String getCountry() {

        return country;

    }



    public void setCountry(String country) {

        this.country = country;

    }



    public String getIdentifyNumber() {

        return identifyNumber;

    }



    public void setIdentifyNumber(String identifyNumber) {

        this.identifyNumber = identifyNumber;

    }

}