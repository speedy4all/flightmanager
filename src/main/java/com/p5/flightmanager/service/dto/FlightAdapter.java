package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.models.Plane;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FlightAdapter {

    public final static FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();

        flightDto.setId(flight.getId().toString());
        flightDto.setFlightType(flight.getFlightType());
        flightDto.setName(flight.getName());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());
        if(!StringUtils.isEmpty(flight.getLocationAirport().getLocation()) && !StringUtils.isEmpty(flight.getDestinationAirport().getLocation())) {
            flightDto.setFullFlightDescription(flight.getLocationAirport().getLocation().concat("-").concat(flight.getDestinationAirport().getLocation()));
        }
        flightDto.setDurationTime(flight.getDurationTime());
        if(flight.getPlane() != null) {
            flightDto.setPlane(PlaneAdapter.toDto(flight.getPlane()));
        }
        if(flight.getDestinationAirport() != null) {
            flightDto.setDestinationAirport(AirportAdapter.toDto(flight.getDestinationAirport()));
        }
        if(flight.getLocationAirport() != null) {
            flightDto.setLocationAirport(AirportAdapter.toDto(flight.getLocationAirport()));
        }
        flightDto.setPassengers(PassengerAdapter.toListDto(flight.getPassengerList()));

        return flightDto;
    }

    public final static Flight fromDto(FlightDto flightDto)
    {
        Flight flight = new Flight();
        fromDto(flightDto,flight);

        return flight;
    }

    public final static FlightDtoSimple toSimpleDto(Flight flight) {
        FlightDtoSimple flightDto = new FlightDtoSimple();

        flightDto.setFlightId(flight.getId());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());
        flightDto.setDurationTime(flight.getDurationTime());
        flightDto.setDepartureAirportCode(flight.getLocationAirport().getCode());
        flightDto.setDepartureAirportName(flight.getLocationAirport().getName());
        flightDto.setDestinationAirportCode(flight.getDestinationAirport().getCode());
        flightDto.setDestinationAirportName(flight.getDestinationAirport().getName());
        flightDto.setSeatsAvailable(flight.getPlane().getSeats() - flight.getPassengerList().size());
        flightDto.setPlaneType(flight.getPlane().getModel());

        return flightDto;
    }


    public final static Flight fromPostDto(PostFlightDto postFlightDto, Plane plane, Airport location, Airport destination) {
        Flight flight = new Flight();
        flight.setName(postFlightDto.getName());
        flight.setFlightType(postFlightDto.getFlightType());
        flight.setDepartureDate(postFlightDto.getDepartureDate());
        flight.setDestinationDate(postFlightDto.getDestinationDate());
        flight.setDurationTime(postFlightDto.getDurationTime());
        flight.setPlane(plane);
        flight.setLocationAirport(location);
        flight.setDestinationAirport(destination);
        return flight;
    }

    public final static Flight fromDto(FlightDto flightDto, Flight flight)
    {
        flight.setName(flightDto.getName());
        flight.setFlightType(flightDto.getFlightType());
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setDestinationDate(flightDto.getDestinationDate());
        flight.setDurationTime(flightDto.getDurationTime());
        flight.setDestinationAirport(AirportAdapter.fromDto(flightDto.getDestinationAirport()));

        return flight;
    }


    public final static List<FlightDto> toListDto(Iterable<Flight> flightList) {
        List<FlightDto> listDto = new ArrayList<>();
        flightList.forEach(flight -> listDto.add(toDto(flight)));

        return listDto;
    }

    public final static List<FlightDtoSimple> toListDtoSimple(Iterable<Flight> flightList) {
        List<FlightDtoSimple> listDto = new ArrayList<>();
        flightList.forEach(flight -> listDto.add(toSimpleDto(flight)));
        return listDto;
    }

    public final static List<FlightDtoSimple> toListSimpleDto(Iterable<Flight> flightList) {
        List<FlightDtoSimple> listDto = new ArrayList<>();
        flightList.forEach(flight -> listDto.add(toSimpleDto(flight)));

        return listDto;
    }

    public static List<FlightDtoView> toListDtoView(Iterable<FlightDtoView> flights) {
        List<FlightDtoView> listDto = new ArrayList<>();
        flights.forEach(flight -> listDto.add(toDtoView(flight)));
        return listDto;
    }

    private static FlightDtoView toDtoView(FlightDtoView flight) {
        FlightDtoView flightDto = new FlightDtoView();

        flightDto.setIdFlight(flight.getIdFlight());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());
        flightDto.setDurationTime(flight.getDurationTime());
        return flightDto;

    }
}
