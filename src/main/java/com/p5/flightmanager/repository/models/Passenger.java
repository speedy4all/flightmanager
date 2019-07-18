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

    @Column(name = "npc")
    @Type(type = "string")
    private String npc;

    @Column(name = "birth_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    public Passenger() {
        //default constructor
    }

    public Passenger(String firstName, String lastName, String npc, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.npc = npc;
        this.birthDate = birthDate;
    }

    public Passenger(Passenger source) {
        super(source);
        this.firstName = source.firstName;
        this.lastName = source.lastName;
        this.npc = source.npc;
        this.birthDate = source.birthDate;
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

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
