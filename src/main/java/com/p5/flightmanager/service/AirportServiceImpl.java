package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportRepository;
import com.p5.flightmanager.repository.models.Airport;


import com.p5.flightmanager.service.api.AirportService;

import com.p5.flightmanager.service.dto.AirportDto;


import com.p5.flightmanager.service.dto.adapter.AirportAdapter;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoFlightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;


    public List<AirportDto> getAll(String search) {

        return com.p5.flightmanager.service.dto.adapter.AirportAdapter.toListDto(airportRepository.filterByName(search));
    }

    @Override
    public AirportDto createAirport(AirportDto airportDto) {

        Airport airport = null;
        //Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        if(isValidFlight(airportDto)) {

            airport = airportRepository.save(com.p5.flightmanager.service.dto.adapter.AirportAdapter.fromDto(airportDto));
        } else {
            throw new EmptyFieldException();

        }
        return com.p5.flightmanager.service.dto.adapter.AirportAdapter.toDto(airport);
    }

    @Autowired
    public AirportDto UpdateAirport(AirportDto airportDto) {
        Optional<Airport> optionalAirport = airportRepository.findById(UUID.fromString(airportDto.getId()));
        if(optionalAirport.isPresent()) {

            Airport airport = optionalAirport.get();
            airport = com.p5.flightmanager.service.dto.adapter.AirportAdapter.fromDto(airportDto, airport);
            airportRepository.save(airport);
            return com.p5.flightmanager.service.dto.adapter.AirportAdapter.toDto(airport);
        }
        throw new NoFlightException();
    }

    @Override
    public AirportDto getById(String id) {
        Optional<Airport> optionalAirport = airportRepository.findById(UUID.fromString(id));
        if(optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            return AirportAdapter.toDto(airport);
        }
        throw new NoFlightException();
    }

    @Override
    public AirportDto updateAirport(AirportDto airportDto) {
        return null;
    }

    @Override
    public void deleteAirport(String id) {
        Optional<Airport> optionalAirport = airportRepository.findById(UUID.fromString(id));
        if(optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            airportRepository.delete(airport);
        }
    }

    private  boolean isValidFlight(AirportDto airportDto) {
        if(airportDto.getLocation()== null || airportDto.getLocation().isEmpty())
            return false;
        return true;
    }
}
