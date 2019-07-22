package com.p5.flightmanager.service.dto;

import java.util.UUID;

public class AirportSimpleDto {

    private String id;
    private String name;
    private String code;

    public AirportSimpleDto(UUID id, String name, String code) {
        this.id = id.toString();
        this.name = name;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
