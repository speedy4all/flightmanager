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
        flightDto.setDurationTime(flight.getDurationTime());
        flightDto.setFullFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());

        return flightDto;
    }

    public final static List<FlightDto> toListDto(Iterable<Flight> flightList){
        List<FlightDto> flightsDto = new ArrayList<>();
        flightList.forEach(flight -> flightsDto.add(toDto(flight)));

        return flightsDto;
    }

    public final static Flight fromDto(FlightDto flightDto){
        Flight flight = new Flight();
        return fromDto(flightDto, flight);
    }

    public final static Flight fromDto(FlightDto flightDto, Flight flight){
            flight.setName(flightDto.getName());
            flight.setDepartureLocation(flightDto.getDepartureLocation());
            flight.setDestinationLocation(flightDto.getDestinationLocation());
            flight.setDurationTime(flightDto.getDurationTime());
            flight.setDepartureDate(flightDto.getDepartureDate());
            flight.setDestinationDate(flightDto.getDestinationDate());

        return flight;
    }
}
