package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Airplane;
import com.p5.flightmanager.service.dto.AirplaneDto;

import java.util.ArrayList;
import java.util.List;

public class AirplaneAdapter {

    public final static AirplaneDto toDto(Airplane airplane){
        AirplaneDto airplaneDto = new AirplaneDto();
        airplaneDto.setId(airplane.getId().toString());
        airplaneDto.setName(airplane.getName());
        airplaneDto.setNumberOfSeats(airplane.getNumberOfSeats());
        airplaneDto.setFullDescription(airplane.getName().concat( " has a number of ").concat(airplane.getNumberOfSeats().toString()).concat(" seats"));
        return airplaneDto;
    }

    public final static List<AirplaneDto> toListDto(Iterable<Airplane> airplaneDto) {
        List<AirplaneDto> listDto = new ArrayList<>();
        airplaneDto.forEach(airplane -> listDto.add(toDto(airplane)));
        return listDto;
    }

    public final static Airplane fromDto(AirplaneDto airplaneDto){
        Airplane airplane = new Airplane();
        airplane = fromDto(airplaneDto,airplane);
        return airplane;
    }

    public final static Airplane fromDto(AirplaneDto airplaneDto, Airplane airplane){
        airplane.setName(airplaneDto.getName());
        airplane.setNumberOfSeats(airplaneDto.getNumberOfSeats());
        return airplane;
    }
}
