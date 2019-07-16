package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportsRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.dto.AirportAdapter;
import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.exceptions.NoAirportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportsRepository airportsRepository;

    @Override
    public List<AirportDto> getAll(String search) {
        return AirportAdapter.toListDto(airportsRepository.filterByName(search));
    }

    @Override
    public AirportDto getById(String id) {
        Optional<Airport> optional = airportsRepository.findById(UUID.fromString(id));
        if(optional.isPresent())
        {
            return AirportAdapter.toDto(optional.get());
        }

        throw new NoAirportException();
    }

    @Override
    public AirportDto updateAirport(AirportDto airportDto) {

        Optional<Airport> optional = airportsRepository.findById(UUID.fromString(airportDto.getId()));
        if(optional.isPresent())
        {
            Airport airport = optional.get();
            airportsRepository.save(AirportAdapter.fromDto(airportDto,airport));
            return AirportAdapter.toDto(AirportAdapter.fromDto(airportDto,airport));
        }
        throw new NoAirportException();
    }

    @Override
    public AirportDto createAirport(AirportDto airportDto) {
        Airport airport = AirportAdapter.fromDto(airportDto);
        airportsRepository.save(airport);
        return AirportAdapter.toDto(airport);
    }

    @Override
    public void delete(String id) {
        Optional<Airport> airportOptional = airportsRepository.findById(UUID.fromString(id));
        if(airportOptional.isPresent())
        {
            airportsRepository.delete(airportOptional.get());
            return;
        }
        throw new NoAirportException();
    }
}
