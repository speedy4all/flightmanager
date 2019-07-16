package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.dto.adapter.AirportAdapter;
import com.p5.flightmanager.service.dto.adapter.FlightAdapter;
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
    private AirportRepository airportRepository;

    @Override
    public List<AirportDto> getAll(String search) {
        if (search == null){
            search = "";
        }

        return AirportAdapter.toListDto(airportRepository.filterByName(search));
    }

    @Override
    public AirportDto createAirport(AirportDto airportDto) {
        Airport airport;
        if (isValidAirport(airportDto)){
            airport = airportRepository.save(AirportAdapter.fromDto(airportDto));
        } else {
            throw new EmptyFieldException();
        }

        return AirportAdapter.toDto(airport);
    }

    @Override
    public AirportDto getById(String id) {
        Optional<Airport> airportOptional = airportRepository.findById(UUID.fromString(id));
        if (airportOptional.isPresent()){
            Airport airport = airportOptional.get();

            return AirportAdapter.toDto(airport);
        }

        throw new NoAirportException();
    }

    @Override
    public AirportDto updateAirport(AirportDto airportDto) {
        Optional<Airport> airportOptional = airportRepository.findById(UUID.fromString(airportDto.getId()));
        Airport airport;

        if (airportOptional.isPresent()){
            airport = airportRepository.save(AirportAdapter.fromDto(airportDto, airportOptional.get()));
        } else {
            throw new NoAirportException();
        }

        return AirportAdapter.toDto(airport);
    }

    @Override
    public void deleteAirport(String id) {
        Optional<Airport> airportOptional = airportRepository.findById(UUID.fromString(id));

        if (airportOptional.isPresent()){
            airportRepository.delete(airportOptional.get());
        } else {
            throw new NoAirportException();
        }
    }

    private boolean isValidAirport(AirportDto airportDto){
        if (airportDto.getCode().chars().count() != 3){
            return false;
        }

        return true;
    }
}
