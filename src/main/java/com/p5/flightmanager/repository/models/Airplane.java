package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name="T_AIRPLANES")
public class Airplane extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    public Airplane() {
        //default constructor
    }
    public Airplane(String name, Integer seatsNumber, String baseColor, Integer weight,Integer enginesNumber) {
        this.Name = name;
        this.SeatsNumber = seatsNumber;
        this.BaseColor= baseColor;
        this.Weight = weight;
        this.EnginesNumber = enginesNumber;
    }

    public Airplane(Airplane source) {
        super(source);
        this.Name = source.Name;
        this.SeatsNumber = source.SeatsNumber;
        this.BaseColor = source.BaseColor;
        this.Weight = source.Weight;
        this.EnginesNumber = source.EnginesNumber;
    }



    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    @Column(name = "id", updatable = false, unique = true)
    private UUID Id;

    @Column(name="name")
    @Type(type="string")
    private String Name;

    @Column(name="basecolor")
    @Type(type="string")
    private String BaseColor;


    @Column(name="seatsnumber")
    @Type(type="integer")
    private Integer SeatsNumber;

    @Column(name="weight")
    @Type(type="integer")
    private Integer Weight;

    @Column(name="enginesnumber")
    @Type(type="integer")
    private Integer EnginesNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public UUID getId() {
        return Id;
    }

    @Override
    public void setId(UUID id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBaseColor() {
        return BaseColor;
    }

    public void setBaseColor(String baseColor) {
        BaseColor = baseColor;
    }

    public Integer getSeatsNumber() {
        return SeatsNumber;
    }

    public void setSeatsNumber(Integer seatsNumber) {
        SeatsNumber = seatsNumber;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    public Integer getEnginesNumber() {
        return EnginesNumber;
    }

    public void setEnginesNumber(Integer enginesNumber) {
        EnginesNumber = enginesNumber;
    }
}
