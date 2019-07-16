package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengersRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.PassengerAdapter;
import com.p5.flightmanager.service.dto.PassengerDto;
import com.p5.flightmanager.service.exceptions.NoPassengerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassengerServiceImpl implements PassengerService {


    @Autowired
    private PassengersRepository passengerRepository;

    @Override
    public List<PassengerDto> getAll(String search) {
        return PassengerAdapter.toListDto(passengerRepository.filterByFirstName(search));

    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {

        Passenger passenger = passengerRepository.save(PassengerAdapter.fromDto(passengerDto));

        return PassengerAdapter.toDto(passenger);
    }

    @Override
    public PassengerDto getById(String id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(id));
        if(optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            return PassengerAdapter.toDto(passenger);
        }
        throw new NoPassengerException();
    }

    @Override
    public PassengerDto updatePassenger(PassengerDto passengerDto) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(passengerDto.getId()));
        if(optionalPassenger.isPresent()){
            Passenger passenger = optionalPassenger.get();
            passengerRepository.save(PassengerAdapter.fromDto(passengerDto,passenger));
            return PassengerAdapter.toDto(PassengerAdapter.fromDto(passengerDto,passenger));
        }
        throw new NoPassengerException();
    }

    @Override
    public void deletePassenger(String passengerDtoID) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(passengerDtoID));
        if(optionalPassenger.isPresent()){
            Passenger passenger = optionalPassenger.get();
            passengerRepository.delete(passenger);
            return;
        }
        throw new NoPassengerException();
    }

}
