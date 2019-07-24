package com.p5.flightmanager.service;



import com.p5.flightmanager.repository.PassengerRepository;

import com.p5.flightmanager.repository.models.Passenger;

import com.p5.flightmanager.service.api.PassengerService;

import com.p5.flightmanager.service.dto.PassengerAdapter;

import com.p5.flightmanager.service.dto.PassengerDto;

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



    public boolean isValidPassenger(PassengerDto passengerDto){

        if(passengerDto.getFirstName() == null || passengerDto.getFirstName().isEmpty())

            return false;

        if(passengerDto.getLastName() == null || passengerDto.getLastName().isEmpty())

            return false;



        return true;

    }



    public static final Integer calculateAge(Date birthDate){

        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        Date currentDate = new Date();

        int d1 = Integer.parseInt(formatter.format(birthDate));

        int d2 = Integer.parseInt(formatter.format(currentDate));

        int age = (d2 - d1) / 10000;

        return age;

    }

}