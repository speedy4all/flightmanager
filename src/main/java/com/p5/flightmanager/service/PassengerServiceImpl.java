package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.FlightAdapter;
import com.p5.flightmanager.service.dto.PassengerAdapter;
import com.p5.flightmanager.service.dto.PassengerDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoFlightException;
import com.p5.flightmanager.service.exceptions.NoPassengerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<PassengerDto> getAll(String search) {
        return PassengerAdapter.toListDto(passengerRepository.filterByName(search));
    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {
        Passenger passenger = null;
        if(isValidPassenger(passengerDto)){
            passenger = passengerRepository.save(PassengerAdapter.fromDto(passengerDto));
        } else {
            throw new EmptyFieldException();
        }

        return PassengerAdapter.toDto(passenger);
    }

    @Override
    public PassengerDto getById(String id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(id));
        if(optionalPassenger.isPresent()){
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
            PassengerAdapter.fromDto(passengerDto, passenger);
            passengerRepository.save(passenger);
            return PassengerAdapter.toDto(passenger);
        }
        throw new NoPassengerException();
    }

    @Override
    public void deletePassenger(String id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(id));
        if(optionalPassenger.isPresent()){
            Passenger passenger = optionalPassenger.get();
            passengerRepository.delete(passenger);
        }
    }

    @Override
    public Passenger getOrCreate(String uniqueIdentifier, String name) {
        Passenger passenger = passengerRepository.getByIdentifyNumber(uniqueIdentifier);

        if (passenger == null) {
            Passenger newPassenger = new Passenger();
            newPassenger.setFirstName(name);
            newPassenger.setIdentifyNumber(uniqueIdentifier);
            Passenger savedPassenger = passengerRepository.save(newPassenger);
            return newPassenger;
        }

        return passenger;
    }

    public boolean isValidPassenger(PassengerDto passengerDto){
        if(passengerDto.getFirstName() == null || passengerDto.getFirstName().isEmpty())
            return false;
        if(passengerDto.getSecondName() == null || passengerDto.getSecondName().isEmpty())
            return false;

        return true;
    }
}