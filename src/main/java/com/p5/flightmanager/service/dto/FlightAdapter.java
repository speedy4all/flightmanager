package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FlightAdapter {
    public final static Flight fromDto(FlightDto flightDto) {
        Flight flight = new Flight();
        fromDto(flightDto, flight);
        return flight;
    }

    public final static Flight fromDto(FlightDto flightDto, Flight flight)
    {
        if(!flightDto.getId().isEmpty() || flightDto.getId() != null) {
            flight.setId(UUID.fromString(flightDto.getId()));
        }

        flight.setName(flightDto.getName());
        flight.setDepartureLocation(flightDto.getDepartureLocation());
        flight.setDestinationLocation(flightDto.getDestinationLocation());
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setDestinationDate(flightDto.getDestinationDate());
        flight.setDurationTime(flightDto.getDurationTime());
        return flight;

    }

    public final static FlightDto toDto (Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId().toString());
        flightDto.setDepartureLocation(flight.getDepartureLocation());
        flightDto.setDestinationLocation(flight.getDestinationLocation());
        flightDto.setName(flight.getName());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());
        flightDto.setDestinationLocation(flight.getDestinationLocation());
        flightDto.setDurationTime(flight.getDurationTime());
        flightDto.setFullFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));
        return flightDto;
    }

    public final static List<FlightDto> toListDto(Iterable<Flight> flightList) {
        List<FlightDto> listDto = new ArrayList<>();
        flightList.forEach(flight -> listDto.add(toDto(flight)));
        return listDto;
    }
}
