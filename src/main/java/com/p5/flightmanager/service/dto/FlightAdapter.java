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

    public final static ResponseFlightDto toResponseDto(Flight flight) {
        ResponseFlightDto flightDto = new ResponseFlightDto();

        flightDto.setFlightId(flight.getId());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDestinationDate(flight.getDestinationDate());
        flightDto.setDurationTime(flight.getDurationTime());
        flightDto.setDepartureAirportCode(flight.getLocationAirport().getCode());
        flightDto.setDepartureAirportName(flight.getLocationAirport().getName());
        flightDto.setDestinationAirportCode(flight.getDestinationAirport().getCode());
        flightDto.setDestinationAirportName(flight.getDestinationAirport().getName());
        flightDto.setAvailableSeats(flight.getPlane().getSeats() - flight.getPassengerList().size());
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

    public static ListResponseDto<ResponseFlightDto> toResponseListDto(Iterable<Flight> flights) {
        ListResponseDto<ResponseFlightDto> response = new ListResponseDto<>();
        flights.forEach(f -> {
            ResponseFlightDto responseFlightDto = new ResponseFlightDto();
            responseFlightDto.setFlightId(f.getId());


            response.getList().add(responseFlightDto);
        });
        return response;
    }
}
