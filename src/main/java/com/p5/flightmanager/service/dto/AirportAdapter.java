package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Airport;

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
        airportDto.setFlights(FlightAdapter.toListDto(airport.getFlights()));

        return airportDto;
    }

    private final static AirportDtoView toDtoView(Airport airport) {
        AirportDtoView airportDtoView = new AirportDtoView();

        airportDtoView.setId(airport.getId().toString());
        airportDtoView.setCity(airport.getCity());
        airportDtoView.setName(airport.getName());

        return airportDtoView;
    }


    public final static List<AirportDto> toListDto(Iterable<Airport> airportList){
        List<AirportDto> listDto = new ArrayList<>();
        airportList.forEach(airport -> listDto.add(toDto(airport)));

        return listDto;
    }

    public final static List<AirportDtoView>  toListDtoView(Iterable<Airport> airports) {
        List<AirportDtoView> listDtoView = new ArrayList<>();
        airports.forEach(airport -> listDtoView.add(toDtoView(airport)));

        return listDtoView;
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
