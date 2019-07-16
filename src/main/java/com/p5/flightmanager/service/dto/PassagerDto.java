package com.p5.flightmanager.service.dto;

public class PassagerDto {
    private String name;
    private Double birthdate;
    private String npc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Double birthdate) {
        this.birthdate = birthdate;
    }

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }
}
