package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengersRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.PassengerAdapter;
import com.p5.flightmanager.service.dto.PassengerDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoPassengerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengersRepository passengersRepository;

    public List<PassengerDto> getAll(String search) {

        return PassengerAdapter.toListDto(passengersRepository.filterByFirstName(search));
    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {

        Passenger passenger = null;
        if (isValidPassenger(passengerDto)) {
            passenger = passengersRepository.save(PassengerAdapter.fromDto(passengerDto));
        } else {
            throw new EmptyFieldException();
        }
        return PassengerAdapter.toDto(passenger);
    }

    @Override
    public PassengerDto updatePassenger(PassengerDto passengerDto) {
        Optional<Passenger> optionalPassenger = passengersRepository.findById(UUID.fromString(passengerDto.getId()));
        if (optionalPassenger.isPresent()) {

            Passenger passenger = optionalPassenger.get();
            passenger = PassengerAdapter.fromDto(passengerDto, passenger);
            passengersRepository.save(passenger);
            return PassengerAdapter.toDto(passenger);
        }
        throw new NoPassengerException();
    }

    @Override
    public PassengerDto getById(String id) {
        Optional<Passenger> optionalPassenger = passengersRepository.findById(UUID.fromString(id));
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            return PassengerAdapter.toDto(passenger);
        }
        throw new NoPassengerException();
    }

    @Override
    public void deletePassenger(String id) {
        Optional<Passenger> optionalPassenger = passengersRepository.findById(UUID.fromString(id));
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            passengersRepository.delete(passenger);
        }
    }

    private boolean isValidPassenger(PassengerDto passengerDto) {
        if (passengerDto.getFirstName() == null || passengerDto.getFirstName().isEmpty()) {
            return false;
        }
        if (passengerDto.getLastName() == null || passengerDto.getLastName().isEmpty()) {
            return false;
        }

        return true;
    }
}
