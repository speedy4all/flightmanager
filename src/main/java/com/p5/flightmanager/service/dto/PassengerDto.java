package com.p5.flightmanager.service.dto;

import java.util.Date;

public class PassengerDto {
    private String id;
    private String firstName;
    private String lastName;
    private String npc;
    private Date birthDate;
    private int age;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }
}
