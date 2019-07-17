package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.dto.AirportDto;

import java.util.ArrayList;
import java.util.List;

public class AirportAdapter {

    public final static AirportDto toDto(Airport airport){
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId().toString());
        airportDto.setFullDescription(airport.getName().concat(" located in ").concat(airport.getLocation()).concat( " has a timezone offset of ").concat(airport.getTimezoneOffset().toString()).concat(" minutes and ").concat(airport.getNumberOfTerminals().toString()).concat(" terminals"));
        airportDto.setIdentificationCode(airport.getIdentificationCode());
        airportDto.setLocation(airport.getLocation());
        airportDto.setName(airport.getName());
        airportDto.setNumberOfTerminals(airport.getNumberOfTerminals());
        airportDto.setTimezoneOffset(airport.getTimezoneOffset());
        return airportDto;
    }

    public final static List<AirportDto> toListDto(Iterable<Airport> airportDto) {
        List<AirportDto> listDto = new ArrayList<>();
        airportDto.forEach(airport -> listDto.add(toDto(airport)));
        return listDto;
    }

    public final static Airport fromDto(AirportDto airportDto){
        Airport airport = new Airport();
        airport = fromDto(airportDto,airport);
        return airport;
    }

    public final static Airport fromDto(AirportDto airportDto, Airport airport){
        airport.setName(airportDto.getName());
        airport.setIdentificationCode(airportDto.getIdentificationCode());
        airport.setLocation(airportDto.getLocation());
        airport.setNumberOfTerminals(airportDto.getNumberOfTerminals());
        airport.setTimezoneOffset(airportDto.getTimezoneOffset());
        return airport;
    }
}
