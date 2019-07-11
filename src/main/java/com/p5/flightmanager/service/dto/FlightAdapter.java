package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightAdapter {

    public final static FlightDto getFlightDto(Flight flight) {
        FlightDto flightdto=new FlightDto();
        flightdto.setName(flight.getName().toString());
        flightdto.setId(flight.getId().toString());
        flightdto.setDeaprtureLocation(flight.getDepartureLocation().toString());
        flightdto.setDestinationLocation(flight.getDestinationLocation().toString());
        flightdto.setFullFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));


        return flightdto;
    }
    public final static List<FlightDto> toListDto(Iterable<Flight> flightList){
        List<FlightDto> listDto= new ArrayList<>();
        flightList.forEach(flight->listDto.add(toDto(flight)));
        return null;
    }
}
