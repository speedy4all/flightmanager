package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.models.Plane;
import com.p5.flightmanager.service.dto.FlightDto;

import java.util.ArrayList;
import java.util.List;

public class FlightAdapter {

    public final static FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        Airport departureAirport = flight.getDepartureAirport();
        Airport destinationAirport = flight.getDestinationAirport();

        flightDto.setId(flight.getId().toString());
        flightDto.setName(flight.getName());
        flightDto.setFlightType(flight.getFlightType());
        flightDto.setDurationTime(flight.getDurationTime());
        flightDto.setPlaneDto(PlaneAdapter.toDto(flight.getPlane()));

        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());

        flightDto.setDepartureAirport(AirportAdapter.toDto(departureAirport));
        flightDto.setDestinationAirport(AirportAdapter.toDto(destinationAirport));
        flightDto.setPassengerDtos(PassengerAdapter.toListDto(flight.getPassengerList()));

        if(departureAirport != null && destinationAirport != null) {
            flightDto.setFullFlightDescription(departureAirport.getIata().concat("-").concat(destinationAirport.getIata()));
        }

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
        flight.setDurationTime(flightDto.getDurationTime());
        flight.setPlane(PlaneAdapter.fromDto(flightDto.getPlaneDto()));

        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setDestinationDate(flightDto.getDestinationDate());

//        flight.setDepartureAirport(AirportAdapter.fromDto(flightDto.getDepartureAirport()));
//        flight.setDestinationAirport(AirportAdapter.fromDto(flightDto.getDestinationAirport()));
//        flight.setPassengerList(PassengerAdapter.fromDto());

        return flight;
    }
}
