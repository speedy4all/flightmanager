package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="T_PASSAGER")
public class Passenger extends BaseModel implements Serializable {
    public static final long serialVersionUID=1L;
    public Passenger(){

    }

    public Passenger(Passenger source) {
        super(source);
        this.name=source.name;
        this.birthDate=source.birthDate;
        this.npc=source.npc;
    }

    public Passenger(String name, Double birthDate, String npc){
        this.name=name;
        this.birthDate=birthDate;
        this.npc=npc;

    }
    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name="birth_Date")
    @Type(type="double")
    private Double birthDate;

    @Column(name="npc")
    @Type(type="string")
    private String npc;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Double birthDate) {
        this.birthDate = birthDate;
    }

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }
}

