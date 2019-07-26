package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.exceptions.*;
import org.springframework.http.HttpStatus;

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
        verifyFlight(flight);
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

    public static ListResponseDto<ResponseFlightDto> toListResponse(Iterable<Flight> flights) {
        ListResponseDto<ResponseFlightDto> response = new ListResponseDto<>();
        flights.forEach(f -> {
            verifyFlight(f);
            ResponseFlightDto responseFlightDto = new ResponseFlightDto();
            responseFlightDto.setFlightId(f.getId());
            responseFlightDto.setAvailableSeats(f.getPlane().getSeats()-f.getPassengerList().size());
            responseFlightDto.setDepartureAirportCode(f.getDepartureLocation().getIata());
            responseFlightDto.setDepartureAirportName(f.getDepartureLocation().getName());
            responseFlightDto.setDepartureDate(f.getDepartureDate());
            responseFlightDto.setDestinationAirportCode(f.getDestinationLocation().getIata());
            responseFlightDto.setDestinationAirportName(f.getDestinationLocation().getName());
            responseFlightDto.setFlightDuration(f.getDurationTime());
            responseFlightDto.setPlaneType(f.getPlane().getModel());
            responseFlightDto.setDestinationDate(f.getDestinationDate());
            response.getList().add(responseFlightDto);
            Long increment =  response.getTotalCount()+1;
            response.setTotalCount(increment);
        });
        return response;
    }

    private static final void verifyFlight(Flight flight) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        if(flight.getPlane() == null) {
            apiError.getSubErrors().add(new ApiSubError("plane", "not found"));
        }
        if(flight.getDestinationLocation() == null) {
            apiError.getSubErrors().add(new ApiSubError("destination airport", "not found"));
        }
        if(flight.getDepartureLocation() == null) {
            apiError.getSubErrors().add(new ApiSubError("departure airport", "not found"));
        }

        if(apiError.getSubErrors().size() > 0){
            throw new FlightException(apiError);
        }

    }

}
