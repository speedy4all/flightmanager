package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoFlightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    public List<FlightDto> getAll(String search) {
//        List<FlightDto> flightDtos = FlightAdapter.toListDto(flightsRepository.findAll());
//        List<FlightDto> collect = flightDtos.stream().filter(x -> x.getName().contains(search)).collect(Collectors.toList());
//        return flightdtos;
        // -> complexitate mare (le aduce pe toate)

        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {

        if(!isValidFlight(flightDto))
        {
            throw new EmptyFieldException();
        }

        Flight flight = flightsRepository.save(FlightAdapter.fromDto(flightDto));

        return FlightAdapter.toDto(flight);
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
    public FlightDto updateFlight(FlightDto flightDto) {

         Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
         if(optionalFlight.isPresent()){
             Flight flight = optionalFlight.get();
             flightsRepository.save(FlightAdapter.fromDto(flightDto,flight));
             return FlightAdapter.toDto(FlightAdapter.fromDto(flightDto,flight));
         }

        throw new NoFlightException();
    }

    @Override
    public void deleteFlight(String flightDtoID) {

        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDtoID));
        if(optionalFlight.isPresent()){
            flightsRepository.delete(optionalFlight.get());
            return;
        }

        throw new NoFlightException();
    }

    private boolean isValidFlight(FlightDto flightDto) {

        if(flightDto.getDepartureLocation() == null || flightDto.getDepartureLocation().isEmpty()) {
            return false;
        }
        if(flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty()) {
            return false;
        }
        return true;
    }
}
