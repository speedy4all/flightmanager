package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.dto.AirportDto;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class AirportAdapter {
    public final static AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();

        airportDto.setId(airport.getId());
        airportDto.setName(airport.getName());
        airportDto.setLocation(airport.getLocation());
        airportDto.setFlightsAvailable(airport.getFlightsAvailable());
        airportDto.setCountry(airport.getCountry());


        return airportDto;
    }

    public final static List<AirportDto> toListDto(Iterable<Airport> airportList) {
        List<AirportDto> airportDtos = new ArrayList<>();
        airportList.forEach(airport -> airportDtos.add(toDto(airport)));

        return airportDtos;
    }

    public final static Airport fromDto(AirportDto airportDto) {
        Airport airport = new Airport();
        return fromDto(airportDto, airport);
    }

    public final static Airport fromDto(AirportDto airportDto, Airport airport) {
        airport.setName(airportDto.getName());
        airport.setLocation(airportDto.getLocation());
        airport.setFlightsAvailable(airportDto.getFlightsAvailable());
        airport.setOffset(airportDto.getOffset());
        airport.setCountry(airportDto.getCountry());

        return airport;
    }
}
