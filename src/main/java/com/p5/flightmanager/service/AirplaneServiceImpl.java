package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirplaneRepository;
import com.p5.flightmanager.repository.models.Airplane;
import com.p5.flightmanager.repository.models.Airport;


import com.p5.flightmanager.service.api.AirplaneService;

import com.p5.flightmanager.service.dto.AirplaneDto;
import com.p5.flightmanager.service.dto.AirportDto;


import com.p5.flightmanager.service.dto.adapter.AirplaneAdapter;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoFlightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;


    public List<AirplaneDto> getAll(String search) {

        return com.p5.flightmanager.service.dto.adapter.AirplaneAdapter.toListDto(airplaneRepository.filterByName(search));
    }

    @Override
    public AirplaneDto createAirplane(AirplaneDto airplaneDto) {

        Airplane airplane = null;
        //Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        if(isValidFlight(airplaneDto)) {

            airplane = airplaneRepository.save(com.p5.flightmanager.service.dto.adapter.AirplaneAdapter.fromDto(airplaneDto));
        } else {
            throw new EmptyFieldException();

        }
        return com.p5.flightmanager.service.dto.adapter.AirplaneAdapter.toDto(airplane);
    }

    @Override
    public FlightDto updateFlight(FlightDto flightDto) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
        if(optionalFlight.isPresent()) {

            Flight flight = optionalFlight.get();
            flight = com.p5.flightmanager.service.dto.adapter.FlightAdapter.fromDto(flightDto, flight);
            flightsRepository.save(flight);
            return com.p5.flightmanager.service.dto.adapter.FlightAdapter.toDto(flight);
        }
        throw new NoFlightException();
    }

    @Override
    public FlightDto getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            return FlightAdapter.toDto(flight);
        }
        throw new NoFlightException();
    }

    @Override
    public void deleteFlight(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flightsRepository.delete(flight);
        }
    }

    private  boolean isValidFlight(FlightDto flightDto) {
        if(flightDto.getDepartureLocation()== null || flightDto.getDepartureLocation().isEmpty())
            return false;
        if(flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty())
            return false;
        return true;
    }
}

}
