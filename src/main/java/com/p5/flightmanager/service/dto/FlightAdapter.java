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


        flightDto.setFlightType(flight.getFlightType());
        flightDto.setId(flight.getId().toString());
        flightDto.setName(flight.getName());

        flightDto.setDepartureLocation(flight.getDepartureLocation().getCity());

        flightDto.setFullFlightDescription(flight.getDepartureLocation().getCity().concat("-").concat(flight.getDestinationLocation().getCity()));

        flightDto.setDestinationLocation(flight.getDestinationLocation().getCity());

        flightDto.setDurationTime(flight.getDurationTime());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());

        flightDto.setPassengerDtos(PassengerAdapter.toListDto(flight.getPassengerList()));

        return flightDto;
    }

    public final static FlightDtoView toDtoView(Flight flight) {

        FlightDtoView flightDtoView = new FlightDtoView();

        flightDtoView.setId(flight.getId().toString());
        flightDtoView.setName(flight.getName());
        flightDtoView.setDepartureLocation(flight.getDepartureLocation().getCity());
        flightDtoView.setDestinationLocation(flight.getDestinationLocation().getCity());
        flightDtoView.setDurationTime(flight.getDurationTime());
        flightDtoView.setDepartureDate(flight.getDepartureDate());
        flightDtoView.setFreeSeats(flight.getPlane().getSeats());
        flightDtoView.setDestinationDate(flight.getDestinationDate());
        flightDtoView.setDeparureId(flight.getDepartureLocation().getId().toString());
        flightDtoView.setDestinationId(flight.getDestinationLocation().getId().toString());

        flightDtoView.setDestinationAirportName(flight.getDestinationLocation().getName());
        flightDtoView.setDestinationAirportCode(flight.getDestinationLocation().getIata());

        flightDtoView.setDepartureAirportName(flight.getDepartureLocation().getName());
        flightDtoView.setDepartureAirportCode(flight.getDepartureLocation().getIata());

        flightDtoView.setPlaneModel(flight.getPlane().getModel());

        return flightDtoView;
    }


    public final static List<FlightDto> toListDto(Iterable<Flight> flightList) {
        List<FlightDto> listDto = new ArrayList<>();
        flightList.forEach(flight -> listDto.add(toDto(flight)));

        return listDto;
    }

    //
    public final static List<FlightDtoView> toListDtoView(Iterable<Flight> flightList) {
        List<FlightDtoView> listDtoView = new ArrayList<>();
        flightList.forEach(flight -> listDtoView.add(toDtoView(flight)));

        return listDtoView;
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
        //flight.setDestinationLocation(flightDto.getDestinationLocation());
        flight.setDurationTime(flightDto.getDurationTime());
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setDestinationDate(flightDto.getDestinationDate());

        return flight;
    }
}