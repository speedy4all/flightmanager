package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportRepository;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.dto.AirportSimpleDto;
import com.p5.flightmanager.service.dto.adapter.AirportAdapter;
import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoAirportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private FlightsRepository flightsRepository;

    @Override
    public List<AirportDto> getAll(String search) {
        return AirportAdapter.toListDto(airportRepository.filterByName(search));
    }

    @Override
    public AirportDto createAirport(AirportDto airportDto) {
        Airport airport = null;
        if(isValidAirport(airportDto)){
            airport = airportRepository.save(AirportAdapter.fromDto(airportDto));
        } else
        {
            throw new EmptyFieldException();
        }

        return AirportAdapter.toDto(airport);
    }

    @Override
    public AirportDto getById(String id) {
        Optional<Airport> optionalAirport = airportRepository.findById(UUID.fromString(id));
        if(optionalAirport.isPresent()){
            Airport airport = optionalAirport.get();
            return AirportAdapter.toDto(airport);
        }
        throw new NoAirportException();
    }

    @Override
    public AirportDto getByIata(String iata) {
        Optional<Airport> optionalAirport = airportRepository.findByIata(iata);
        if (optionalAirport.isPresent()){
            return AirportAdapter.toDto(optionalAirport.get());
        }
        throw new NoAirportException();
    }

    @Override
    public AirportDto updateAirport(AirportDto airportDto) {
        Optional<Airport> optionalAirport = airportRepository.findById(UUID.fromString(airportDto.getId()));
        if(optionalAirport.isPresent()){
            Airport airport = optionalAirport.get();
            AirportAdapter.fromDto(airportDto, airport);
            airportRepository.save(airport);
            return AirportAdapter.toDto(airport);
        }
        throw new NoAirportException();
    }

    @Override
    public void deleteAirport(String id) {
        Optional<Airport> optionalAirport = airportRepository.findById(UUID.fromString(id));
        if(optionalAirport.isPresent()){
            Airport airport = optionalAirport.get();
            airportRepository.delete(airport);
        }
    }

    public boolean isValidAirport(AirportDto airportDto){
        if(StringUtils.isEmpty(airportDto.getName()))
        {
            return false;
        }
        return true;
        //TODO: api error
    }

    @Override
    public void addFlightToAirport(String airportId, String flightId) {
        Optional<Airport> optionalAirport = airportRepository.findById(UUID.fromString(airportId));
        if (optionalAirport.isPresent()) {
            Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
             if (optionalFlight.isPresent()) {
                Airport airport = optionalAirport.get();
                airport.getFlightsList().add(optionalFlight.get());
                airportRepository.save(airport);
            }
        }
    }

    @Override
    public Iterable<AirportSimpleDto> getAllSimpleAirports() {
        return airportRepository.getAllSimpleAirports();
    }
}
