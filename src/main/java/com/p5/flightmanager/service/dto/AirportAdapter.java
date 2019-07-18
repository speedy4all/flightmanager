package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class AirportAdapter {

    public final static AirportDto toDto(Airport airport){
        AirportDto airportDto=new AirportDto();
        airportDto.setId(airport.getId().toString());
        airportDto.setName(airport.getName());
        airportDto.setCity(airport.getCity());
        airportDto.setCountry(airport.getCountry());
        airportDto.setTerminals(airport.getTerminals());
        airportDto.setCode(airport.getCode());
        airportDto.setTimezoneOffset(airport.getTimezoneoffset());
        airportDto.setFlightList(FlightAdapter.toListDto(airport.getFlightList()));
        return airportDto;
    }
    public static List<AirportDto> toListDto(Iterable<Airport> airports) {
        List<AirportDto> listDto = new ArrayList<>();
        airports.forEach(airport -> airportDtos.add(toDto(airport)));
        return airportDtos;
    }
    public final static Airport fromDto(AirportDto airportDto) {
        Airport airport = new Airport();
        return fromDto(airportDto, airport);
    }
    public final static Airport fromDto(AirportDto airportDto,Airport airport){
        airport.setName(airportDto.getName());
        airport.setCity(airportDto.getCity());
        airport.setCountry(airportDto.getCountry());
        airport.setTerminals(airportDto.getTerminals());
        airport.setCode(airportDto.getCode());
        airport.setTimezoneOffset(airportDto.getTimezoneOffset());
        return airport;
    }


}
