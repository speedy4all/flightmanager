package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.dto.AirportDto;

import java.util.ArrayList;
import java.util.List;

public class AirportAdapter {

    public final static AirportDto toDto(Airport airport){
        AirportDto airportDto = new AirportDto();

        airportDto.setId(airport.getId().toString());
        airportDto.setCity(airport.getCity());
        airportDto.setCountry(airport.getCountry());
        airportDto.setName(airport.getName());
        airportDto.setIATA(airport.getIata());
        airportDto.setOffSet(airport.getOffSet());
        airportDto.setFlightsList(FlightAdapter.toListDto(airport.getFlightsList()));

        return airportDto;
    }

    public final static List<AirportDto> toListDto(Iterable<Airport> airportList){
        List<AirportDto> listDto = new ArrayList<>();
        airportList.forEach(airport -> listDto.add(toDto(airport)));

        return listDto;
    }

    public final static Airport fromDto(AirportDto airportDto){
        Airport airport = new Airport();
        AirportAdapter.fromDto(airportDto, airport);

        return airport;
    }

    public final static Airport fromDto(AirportDto airportDto, Airport airport){
        airport.setCity(airportDto.getCity());
        airport.setCountry(airportDto.getCountry());
        airport.setIata(airportDto.getIATA());
        airport.setName(airportDto.getName());
        airport.setOffSet(airportDto.getOffSet());

        return airport;
    }
}
