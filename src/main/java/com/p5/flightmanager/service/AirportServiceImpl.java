package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.AirportAdapter;
import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.dto.AirportDtoView;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoAirportException;
import com.p5.flightmanager.service.exceptions.NoFlightException;
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

    @Override
    public List<AirportDto> getAll(String search) {
        return AirportAdapter.toListDto(airportRepository.filterByName(search));
    }

    @Override
    public List<AirportDtoView> getAirports() {

        return AirportAdapter.toListDtoView(airportRepository.findAll());
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

    @Override
    public void addFlight(String airportId, String flightId) {

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
    public Optional<Airport> getByName(String name) {
        return airportRepository.findByCity(name);
    }
}
