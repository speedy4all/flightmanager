package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengersRepository;
import com.p5.flightmanager.repository.models.Passengers;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.PassengerAdapter;
import com.p5.flightmanager.service.dto.PassengerDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoPassengerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengersRepository passengersRepository;

    public List<PassengerDto> getAll(String search) {

        return PassengerAdapter.toListDto(passengersRepository.filterByName(search));
    }

    public boolean isValidPassenger(PassengerDto passengerDto) {
        if(passengerDto.getFullname() == null || passengerDto.getFullname().isEmpty())
            return false;
        return true;
    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {

        Passengers passengers = null;
        if(isValidPassenger(passengerDto))
            passengers = passengersRepository.save(PassengerAdapter.fromDto(passengerDto));
        else
            throw new EmptyFieldException();

        return PassengerAdapter.toDto(passengers);

    }

    @Override
    public PassengerDto getById(String id) {
        Optional<Passengers> optionalPassengers = passengersRepository.findById(UUID.fromString(id));
        if(optionalPassengers.isPresent()) {
            Passengers passengers = optionalPassengers.get();
            return PassengerAdapter.toDto(passengers);
        }
        throw new NoPassengerException();
    }

    @Override
    public PassengerDto updatePassenger(PassengerDto passengerDto) {
        if (isValidPassenger(passengerDto)) {
            Optional<Passengers> optionalPassengers = passengersRepository.findById(UUID.fromString(passengerDto.getId()));
            if (optionalPassengers.isPresent()) {
                Passengers passengers = passengersRepository.save(PassengerAdapter.fromDto(passengerDto, optionalPassengers.get()));
                return PassengerAdapter.toDto(passengers);
            }
        }
        throw new EmptyFieldException();
    }

    @Override
    public void deletePassenger(String id) {

        Optional<Passengers> optionalPassengers = passengersRepository.findById((UUID.fromString(id)));
        if(optionalPassengers.isPresent()) {
            Passengers passengers = optionalPassengers.get();
            passengersRepository.delete(passengers);
        } else
            throw new EmptyFieldException();
    }
}
