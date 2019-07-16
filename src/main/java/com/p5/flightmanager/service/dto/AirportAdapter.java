package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportAdapter {

    public final static AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId().toString());
        airportDto.setCode(airport.getCode());
        airportDto.setLocation(airport.getLocation());
        airportDto.setUtcOffset(airport.getUtcOffset());
        airportDto.setFullAirportDetails(airportDto.getCode().concat("-").concat(airportDto.getLocation()).concat("-").concat(airportDto.getUtcOffset().toString()));

        return airportDto;
    }

    public final static List<AirportDto> toListDto(Iterable<Airport> airportList) {
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
        airport.setCode(airportDto.getCode());
        airport.setLocation(airportDto.getLocation());
        airport.setUtcOffset(airportDto.getUtcOffset());

        return airport;
    }
}
