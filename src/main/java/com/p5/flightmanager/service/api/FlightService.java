package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightSearchDto;
import com.p5.flightmanager.service.dto.FlightSimpleDto;
import com.p5.flightmanager.service.dto.FlightUpdateDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FlightService {

    List<FlightDto> getAll(String search);

    FlightDto createFlight(FlightDto flightDto);

    FlightDto getById(String id);

    FlightDto updateFlight(FlightDto flightDto);

    void deleteFlight(String id);

    void addPassengerToFlight(String flightId, String passengerId);

    void associatePlaneToFlight(String flightId, String planeId);

    List<FlightDto> getBySearchParams(Date departureDate, String location, String destination);

    void setDepartureAndDestinationAirport(String flightId, String departureAirportIata, String destinationAirportIata);

    Iterable<FlightSimpleDto> getSimpleFlightDto();

    List<FlightSimpleDto> searchBy(FlightSearchDto search);

    void addPassenger(FlightUpdateDto flightUpdateDto);
}
