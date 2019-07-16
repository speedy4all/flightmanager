package com.p5.flightmanager.service.dto;

import java.util.UUID;

public class AirplaneDto {

    private Integer EnginesNumber;
    private Integer Weight;
    private Integer SeatsNumber;
    private String BaseColor;
    private String Name;

    public Integer getEnginesNumber() {
        return EnginesNumber;
    }

    public void setEnginesNumber(Integer enginesNumber) {
        EnginesNumber = enginesNumber;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    public Integer getSeatsNumber() {
        return SeatsNumber;
    }

    public void setSeatsNumber(Integer seatsNumber) {
        SeatsNumber = seatsNumber;
    }

    public String getBaseColor() {
        return BaseColor;
    }

    public void setBaseColor(String baseColor) {
        BaseColor = baseColor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    private UUID Id;
}
