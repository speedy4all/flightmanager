package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.AirportsRepository;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.dto.AirportAdapter;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoAirportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportsRepository airportsRepository;

    public List<AirportDto> getAll(String search) {

        return AirportAdapter.toListDto(airportsRepository.filterByName(search));
    }

    @Override
    public AirportDto createAirport(AirportDto airportDto) {

        Airport airport = null;
        //Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        if(isValidAirport(airportDto)) {
            airport = airportsRepository.save(AirportAdapter.fromDto(airportDto));
        } else {
            throw new EmptyFieldException();

        }
        return AirportAdapter.toDto(airport);
    }

    @Override
    public AirportDto updateAirport(AirportDto airportDto) {
        Optional<Airport> optionalAirport = airportsRepository.findById(UUID.fromString(airportDto.getId()));
        if(optionalAirport.isPresent()) {

            Airport airport = optionalAirport.get();
            airport = AirportAdapter.fromDto(airportDto, airport);
            airportsRepository.save(airport);
            return AirportAdapter.toDto(airport);
        }
        throw new NoAirportException();
    }

    @Override
    public AirportDto getById(String id) {
        Optional<Airport> optionalAirport = airportsRepository.findById(UUID.fromString(id));
        if(optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            return AirportAdapter.toDto(airport);
        }
        throw new NoAirportException();
    }

    @Override
    public void deleteAirport(String id) {
        Optional<Airport> optionalAirport = airportsRepository.findById(UUID.fromString(id));
        if(optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            airportsRepository.delete(airport);
        }
    }

    private  boolean isValidAirport(AirportDto airportDto) {
        if(airportDto.getName() == null || airportDto.getName().isEmpty())
            return false;
        if(airportDto.getLocation() == null || airportDto.getLocation().isEmpty())
            return false;

        return true;
    }
}
