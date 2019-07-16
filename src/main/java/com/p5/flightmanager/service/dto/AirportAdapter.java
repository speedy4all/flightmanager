package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Airport;
import java.util.ArrayList;
import java.util.List;

public class AirportAdapter {

    public final static AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();

        airportDto.setId(airport.getId().toString());
        airportDto.setAltitude(airport.getAltitude());
        airportDto.setCode(airport.getCode());
        airportDto.setLength(airport.getLength());
        airportDto.setLocation(airport.getLocation());
        airportDto.setOffset(airport.getOffset());
        airportDto.setTerminals(airport.getTerminals());

        return airportDto;
    }

    public final static Airport fromDto(AirportDto airportDto)
    {
        Airport airport = new Airport();
        airport = fromDto(airportDto, airport);

        return airport;
    }

    public final static Airport fromDto(AirportDto airportDto, Airport airport) {
        airport.setAltitude(airportDto.getAltitude());
        airport.setCode(airportDto.getCode());
        airport.setLocation(airportDto.getLocation());
        airport.setLength(airportDto.getLength());
        airport.setOffset(airportDto.getOffset());
        airport.setTerminals(airportDto.getTerminals());

        return airport;
    }

    public final static List<AirportDto> toListDto(Iterable<Airport> airports)
    {
        List<AirportDto> airportDtos = new ArrayList<>();
        airports.forEach(airport -> airportDtos.add(toDto(airport)));
        return airportDtos;
    }
}