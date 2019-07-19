package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.dto.PassengerDto;

import java.util.ArrayList;
import java.util.List;

public class PassengerAdapter {

    public final static PassengerDto toDto (Passenger passenger){
        PassengerDto passengerDto = new PassengerDto();

        passengerDto.setId(passenger.getId().toString());
        passengerDto.setAge(passenger.getAge());
        passengerDto.setBirthdayDate(passenger.getBirthdayDate());
        passengerDto.setCountry(passenger.getCountry());
        passengerDto.setEmail(passenger.getEmail());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setSecondName(passenger.getSecondName());
        passengerDto.setFullName(passenger.getFirstName().concat("-").concat(passenger.getSecondName()));
        passengerDto.setIdentifyNumber(passenger.getIdentifyNumber());
        passengerDto.setPhoneNumber(passenger.getPhoneNumber());
        passengerDto.setSex(passenger.getSex());

        return passengerDto;
    }

    public final static List<PassengerDto> toListDto(Iterable<Passenger> passengerList){
        List<PassengerDto> listDto = new ArrayList<>();
        passengerList.forEach(passenger -> listDto.add(toDto(passenger)));

        return listDto;
    }

    public final static Passenger fromDto(PassengerDto passengerDto){
        Passenger passenger = new Passenger();
        PassengerAdapter.fromDto(passengerDto, passenger);

        return passenger;
    }

    public final static Passenger fromDto(PassengerDto passengerDto, Passenger passenger){
        passenger.setAge(passengerDto.getAge());
        passenger.setBirthdayDate(passengerDto.getBirthdayDate());
        passenger.setCountry(passengerDto.getCountry());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setSecondName(passengerDto.getSecondName());
        passenger.setIdentifyNumber(passengerDto.getIdentifyNumber());
        passenger.setPhoneNumber(passengerDto.getPhoneNumber());
        passenger.setSex(passengerDto.getSex());

        return passenger;
    }
}
