package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.AirportAdapter;
import com.p5.flightmanager.service.dto.FlightDto;

import java.util.ArrayList;
import java.util.List;

public class FlightAdapter {


    public final static FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        Airport departureLocation = flight.getDepartureLocation();

        flightDto.setFlightType(flight.getFlightType());
        flightDto.setId(flight.getId().toString());
        flightDto.setName(flight.getName());

        flightDto.setDepartureLocation(AirportAdapter.toDto(departureLocation));
        flightDto.setDestinationLocation(flight.getDestinationLocation());
        if(departureLocation != null) {
            flightDto.setFullFlightDescription(departureLocation.getIata().concat("-").concat(flight.getDestinationLocation()));
        }
        flightDto.setDurationTime(flight.getDurationTime());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());

        flightDto.setPassengerDtos(PassengerAdapter.toListDto(flight.getPassengerList()));

        return flightDto;
    }


    public final static List<FlightDto> toListDto(Iterable<Flight> flightList) {
        List<FlightDto> listDto = new ArrayList<>();
        flightList.forEach(flight -> listDto.add(toDto(flight)));

        return listDto;
    }

    public final static Flight fromDto(FlightDto flightDto) {
        Flight flight = new Flight();
        FlightAdapter.fromDto(flightDto, flight);

        return flight;

    }

    public final static Flight fromDto(FlightDto flightDto, Flight flight) {

        flight.setName(flightDto.getName());
        flight.setFlightType(flightDto.getFlightType());
        //flight.setDepartureLocation(flightDto.getDepartureLocation());
        flight.setDestinationLocation(flightDto.getDestinationLocation());
        flight.setDurationTime(flightDto.getDurationTime());
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setDestinationDate(flightDto.getDestinationDate());

        return flight;
    }
}
