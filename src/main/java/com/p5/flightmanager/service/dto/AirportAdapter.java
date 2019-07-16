package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportAdapter {

    public final static AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();

        airportDto.setId(airport.getId().toString());
        airportDto.setName(airport.getName());
        airportDto.setCode(airport.getCode());
        airportDto.setLocation(airport.getLocation());
        airportDto.setOffset(airport.getOffset());
        airportDto.setType(airport.getType());

        return airportDto;
    }

    public final static Airport fromDto(AirportDto airportDto)
    {
        Airport airport = new Airport();
        fromDto(airportDto, airport);

        return airport;
    }

    public final static Airport fromDto(AirportDto airportDto, Airport airport) {
        airport.setName(airportDto.getName());
        airport.setCode(airportDto.getCode());
        airport.setLocation(airportDto.getLocation());
        airport.setOffset(airportDto.getOffset());
        airport.setType(airportDto.getType());

        return airport;
    }

    public final static List<AirportDto> toListDto(Iterable<Airport> airportsList) {
        List<AirportDto> listDto = new ArrayList<>();
        airportsList.forEach(airport -> listDto.add(toDto(airport)));

        return listDto;
    }


}

