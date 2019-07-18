package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.PassengerDto;
import com.p5.flightmanager.service.dto.adapter.PassengerAdapter;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoPassengerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<PassengerDto> getAll(String search) {
        if (search == null){
            search = "";
        }

        return PassengerAdapter.toListDto(passengerRepository.filterByName(search.toLowerCase()));
    }

    @Override
    public PassengerDto createPassager(PassengerDto passengerDto) {
        Passenger passenger;
        if (isValidPassager(passengerDto)){
            passenger = passengerRepository.save(PassengerAdapter.fromDto(passengerDto));
        } else {
            // change exception here
            throw new EmptyFieldException();
        }

        return PassengerAdapter.toDto(passenger);
    }

    @Override
    public PassengerDto getById(String id) {
        Optional<Passenger> optionalPassager = passengerRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Passenger passenger = optionalPassager.get();

            return PassengerAdapter.toDto(passenger);
        }

        throw new NoPassengerException();
    }

    @Override
    public PassengerDto updatePassager(PassengerDto passengerDto) {
        Optional<Passenger> optionalPassager = passengerRepository.findById(UUID.fromString(passengerDto.getId()));
        Passenger passenger;

        if(optionalPassager.isPresent()) {
            passenger = passengerRepository.save(PassengerAdapter.fromDto(passengerDto, optionalPassager.get()));
        } else {
            throw new EmptyFieldException();
        }

        return PassengerAdapter.toDto(passenger);
    }

    @Override
    public void deletePassager(String id) {
        Optional<Passenger> optionalPassager = passengerRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Passenger passenger = optionalPassager.get();
            passengerRepository.delete(passenger);
        } else {
            throw new NoPassengerException();
        }
    }

    private boolean isValidPassager(PassengerDto passager){
        if (passager.getNpc().chars().count() != 13){
            return false;
        }
        if (passager.getFirstName().isEmpty() || passager.getLastName().isEmpty()){
            return false;
        }
        if (passager.getBirthDate() == null){
            return false;
        }

        return true;
    }

    public static final int calculateAge(Date birthDate, Date currentDate){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        return (d2 - d1) / 10000;
    }
}
