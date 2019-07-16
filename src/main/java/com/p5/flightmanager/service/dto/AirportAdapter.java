package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportAdapter {


    public final static AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId().toString());
        airportDto.setIdentificationNumber(airport.getIdentificationNumber());
        airportDto.setLocation(airport.getLocation());
        airportDto.setName(airport.getName());
        airportDto.setTerminals(airport.getTerminals());
        airportDto.setOffset(airport.getOffset());
        airportDto.setFullDescription(airport.getName().concat(" - ").concat(airport.getLocation()));
        return airportDto;
    }

    public final static List<AirportDto> toListDto (Iterable<Airport> airportList) {
        List<AirportDto> listDto = new ArrayList<>();
        airportList.forEach(airport -> listDto.add(toDto(airport)));
        return listDto;
    }

    public final static Airport fromDto(AirportDto airportDto) {
        Airport airport = new Airport();
        AirportAdapter.fromDto(airportDto, airport);

        return airport;
    }

    public final static Airport fromDto(AirportDto airportDto, Airport airport) {
        airport.setName(airportDto.getName());
        airport.setIdentificationNumber(airportDto.getIdentificationNumber());
        airport.setLocation((airportDto.getLocation()));
        airport.setOffset(airportDto.getOffset());
        airport.setTerminals(airportDto.getTerminals());

        return airport;
    }
}
