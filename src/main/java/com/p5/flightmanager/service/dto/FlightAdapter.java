package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class FlightAdapter {


    public final static FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId().toString());
        Airport departureLocation = flight.getDepartureLocation();
        Airport destinationLocation = flight.getDestinationLocation();


        flightDto.setFlightType(flight.getFlightType());
        if(departureLocation != null && destinationLocation != null) {
            flightDto.setDepartureLocation(AirportAdapter.toDto(departureLocation));
            flightDto.setFullFlightDescription(departureLocation.getIata().concat("-")
                    .concat(flight.getDestinationLocation().getIata()));
        }
        flightDto.setName(flight.getName());
        if(destinationLocation != null) {
            flightDto.setDestinationLocation(flight.getDestinationLocation().getName());
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

        flight.setDurationTime(flightDto.getDurationTime());
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setDestinationDate(flightDto.getDestinationDate());

        return flight;
    }

    public static ListResponseDto<ResponseFlightDto> toResponseListDto(Iterable<Flight> flights) {

        ListResponseDto<ResponseFlightDto> response = new ListResponseDto<>();
        flights.forEach(f -> {
            ResponseFlightDto responseFlightDto = new ResponseFlightDto();
            responseFlightDto.setFlightId(f.getId());
            responseFlightDto.setDepartureDate(f.getDepartureDate());
            responseFlightDto.setDestinationDate(f.getDestinationDate());

            response.getList().add(responseFlightDto);
        });
        return response;
    }
}
