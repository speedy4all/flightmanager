package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.PassengerServiceImpl;
import com.p5.flightmanager.service.dto.PassengerDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassengerAdapter {
    public static final PassengerDto toDto(Passenger passenger){
        PassengerDto passengerDto = new PassengerDto();

        passengerDto.setBirthDate(passenger.getBirthDate());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setLastName(passenger.getLastName());
        passengerDto.setId(passenger.getId().toString());
        passengerDto.setNpc(passenger.getNpc());
        passengerDto.setAge(PassengerServiceImpl.calculateAge(passenger.getBirthDate(), new Date()));

        return passengerDto;
    }

    public final static List<PassengerDto> toListDto(Iterable<Passenger> passagerList){
        List<PassengerDto> passagersDto = new ArrayList<>();
        passagerList.forEach(passenger -> passagersDto.add(toDto(passenger)));

        return passagersDto;
    }

    public static final Passenger fromDto(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        return fromDto(passengerDto, passenger);
    }

    public static final Passenger fromDto(PassengerDto passengerDto, Passenger passenger){
        passenger.setBirthDate(passengerDto.getBirthDate());
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setNpc(passengerDto.getNpc());

        return passenger;
    }
}
