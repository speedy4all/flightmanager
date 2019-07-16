package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerAdapter {

    public final static PassengerDto toDto(Passenger passenger){
        PassengerDto passengerDto =new PassengerDto();
        passengerDto.setName(passenger.getName());
        passengerDto.setBirthdate(passenger.getBirthDate());
        passengerDto.setNpc(passenger.getNpc());

       return passengerDto;
    }

    public final static Passenger fromDto(PassengerDto passengerDto){
        Passenger passenger =new Passenger();
        PassengerAdapter.fromDto(passengerDto, passenger);
        return passenger;


    }
    public final static Passenger fromDto(PassengerDto passengerDto, Passenger passenger){
        passenger.setName(passengerDto.getName());
        passenger.setBirthDate(passengerDto.getBirthdate());
        passenger.setNpc(passengerDto.getNpc());
        return passenger;



    }

    public static List<PassengerDto> toListDto(Iterable<Passenger> passagerList) {
        List<PassengerDto>listDto=new ArrayList<>();
        passagerList.forEach(passenger ->listDto.add(toDto(passenger)));
        return listDto;

    }
}
