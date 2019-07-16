package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Airplane;
import com.p5.flightmanager.service.dto.AirplaneDto;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class AirplaneAdapter {
    public final static AirplaneDto toDto(Airplane airplane) {
        AirplaneDto airplaneDto = new AirplaneDto();

        airplaneDto.setId(airplane.getId());
        airplaneDto.setName(airplane.getName());
        airplaneDto.setBaseColor(airplane.getBaseColor());
        airplaneDto.setSeatsNumber(airplane.getSeatsNumber());
        airplaneDto.setEnginesNumber(airplane.getEnginesNumber());
        airplaneDto.setWeight(airplane.getWeight());


        return airplaneDto;
    }

    public final static List<AirplaneDto> toListDto(Iterable<Airplane> airplanelist) {
        List<AirplaneDto> airplaneDtos = new ArrayList<>();
        airplanelist.forEach(airplane -> airplaneDtos.add(toDto(airplane)));

        return airplaneDtos;
    }

    public final static Airplane fromDto(AirplaneDto airplaneDto) {
        Airplane airplane = new Airplane();
        return fromDto(airplaneDto, airplane);
    }

    public final static Airplane fromDto(AirplaneDto airplaneDto, Airplane airplane) {
        airplane.setName(airplaneDto.getName());
        airplane.setBaseColor(airplaneDto.getBaseColor());
        airplane.setSeatsNumber(airplaneDto.getSeatsNumber());
        airplane.setEnginesNumber(airplaneDto.getEnginesNumber());
        airplane.setWeight(airplaneDto.getWeight());

        return airplane;
    }
}
