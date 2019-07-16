package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengersRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.PassengersService;
import com.p5.flightmanager.service.dto.PassengersDto;
import com.p5.flightmanager.service.dto.adapter.PassagerAdapter;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoPassengerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassengersServiceImpl implements PassengersService {

    @Autowired
    private PassengersRepository passengersRepository;

    @Override
    public List<PassengersDto> getAll(String search) {
        if (search == null){
            search = "";
        }

        return PassagerAdapter.toListDto(passengersRepository.filterByName(search.toLowerCase()));
    }

    @Override
    public PassengersDto createPassager(PassengersDto passengersDto) {
        Passenger passenger;
        if (isValidPassager(passengersDto)){
            passenger = passengersRepository.save(PassagerAdapter.fromDto(passengersDto));
        } else {
            // change exception here
            throw new EmptyFieldException();
        }

        return PassagerAdapter.toDto(passenger);
    }

    @Override
    public PassengersDto getById(String id) {
        Optional<Passenger> optionalPassager = passengersRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Passenger passenger = optionalPassager.get();

            return PassagerAdapter.toDto(passenger);
        }

        throw new NoPassengerException();
    }

    @Override
    public PassengersDto updatePassager(PassengersDto passengersDto) {
        Optional<Passenger> optionalPassager = passengersRepository.findById(UUID.fromString(passengersDto.getId()));
        Passenger passenger;

        if(optionalPassager.isPresent()) {
            passenger = passengersRepository.save(PassagerAdapter.fromDto(passengersDto, optionalPassager.get()));
        } else {
            throw new EmptyFieldException();
        }

        return PassagerAdapter.toDto(passenger);
    }

    @Override
    public void deletePassager(String id) {
        Optional<Passenger> optionalPassager = passengersRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Passenger passenger = optionalPassager.get();
            passengersRepository.delete(passenger);
        } else {
            throw new NoPassengerException();
        }
    }

    private boolean isValidPassager(PassengersDto passager){
        return true;
    }
}
