package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassagerAdapter {
    public static final PassengersDto toDto(Passenger passenger){
        PassengersDto passengersDto = new PassengersDto();

        passengersDto.setBirthDate(passenger.getBirthDate());
        passengersDto.setFirstName(passenger.getFirstName());
        passengersDto.setLastName(passenger.getLastName());
        passengersDto.setId(passenger.getId().toString());
        //passengersDto.setAge(new Date().getYear() - passenger.getBirthDate().getYear());

        return passengersDto;
    }

    public final static List<PassengersDto> toListDto(Iterable<Passenger> passagerList){
        List<PassengersDto> passagersDto = new ArrayList<>();
        passagerList.forEach(passenger -> passagersDto.add(toDto(passenger)));

        return passagersDto;
    }

    public static final Passenger fromDto(PassengersDto passengersDto) {
        Passenger passenger = new Passenger();
        return fromDto(passengersDto, passenger);
    }

    public static final Passenger fromDto(PassengersDto passengersDto, Passenger passenger){
        passenger.setBirthDate(passengersDto.getBirthDate());
        passenger.setFirstName(passengersDto.getFirstName());
        passenger.setLastName(passengersDto.getLastName());

        return passenger;
    }
}
