package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class FlightAdapter {


    public final static FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId().toString());
        flightDto.setName(flight.getName());
        flightDto.setDepartureLocation(flight.getDepartureLocation());
        flightDto.setDestinationLocation(flight.getDestinationLocation());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());
        flightDto.setFullFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));


        return flightDto;
    }

    public final static Flight fromDto(FlightDto flightdto) {
       Flight flight=new Flight();

       // flight.setId(UUID.fromString(flightdto.getId()));
        flight.setName(flightdto.getName());
        flight.setDepartureLocation(flightdto.getDepartureLocation());
        flight.setDestinationLocation(flightdto.getDestinationLocation());
        flight.setDepartureDate(flightdto.getDepartureDate());
        flight.setDestinationDate(flightdto.getDestinationDate());
        flight.setDurationTime(flightdto.getDurationTime());

        return flight;
    }


    public final static List<FlightDto> toListDto(Iterable<Flight> flightList) {
        List<FlightDto> listDto = new ArrayList<>();
        flightList.forEach(flight -> listDto.add(toDto(flight)));

        return listDto;
    }

    public final static Flight fromDto (FlightDto flightdto,Flight flight){
            // flight.setId(UUID.fromString(flightdto.getId()));
            flight.setName(flightdto.getName());
            flight.setDepartureLocation(flightdto.getDepartureLocation());
            flight.setDestinationLocation(flightdto.getDestinationLocation());
            flight.setDepartureDate(flightdto.getDepartureDate());
            flight.setDestinationDate(flightdto.getDestinationDate());
            flight.setDurationTime(flightdto.getDurationTime());

            return flight;
    }
}
