package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlightAdapter {


    public final static FlightDto toDto(Flight flight){

    FlightDto flightDto = new FlightDto();


        flightDto.setId(flight.getId().toString());
        flightDto.setName(flight.getName());
        flightDto.setDepartureLocation(flight.getDepartureLocation());
        flightDto.setDestinationLocation(flight.getDestinationLocation());
        flightDto.setFullFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));


        return flightDto;
    }


    public final static List<FlightDto> toListDto(Iterable<Flight> flightList) {
        List<FlightDto> listDto = new ArrayList<>();
        flightList.forEach(flight -> listDto.add(toDto(flight)));

        return listDto;
    }

    public final static Flight fromDto(FlightDto flightDto) {
        Flight flight = new Flight();
        return fromDto(flightDto,flight);}





    public final static Flight fromDto(FlightDto flightDto, Flight flight){
        if(flightDto.getId().isEmpty()||flightDto.getId()==null)
        flightDto.setId(flight.getId().toString());
        flightDto.setName(flight.getName());
        flightDto.setDepartureLocation(flight.getDepartureLocation());
        flightDto.setDestinationLocation(flight.getDestinationLocation());
        return flight;

    }

}
