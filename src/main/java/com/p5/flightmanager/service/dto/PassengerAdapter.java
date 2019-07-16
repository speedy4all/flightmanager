package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerAdapter {

    public final static PassengerDto toDto(Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setId(passenger.getId().toString());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setLastName(passenger.getLastName());
        passengerDto.setFullName(passenger.getFirstName().concat("-").concat(passenger.getLastName()));
        passengerDto.setBirthdayDate(passenger.getBirthdayDate());
        passengerDto.setAge(passenger.getAge());
        passengerDto.setGender(passenger.getGender());
        passengerDto.setCnp(passenger.getCnp());
        passengerDto.setPhoneNumber(passenger.getPhoneNumber());
        passengerDto.setEmailAddress(passenger.getEmailAddress());
        passengerDto.setNationality(passenger.getNationality());

        return passengerDto;
    }

    public final static List<PassengerDto> toListDto(Iterable<Passenger> passengerList) {
        List<PassengerDto> listDto = new ArrayList<>();
        passengerList.forEach(passenger -> listDto.add(toDto(passenger)));

        return listDto;
    }

    public final static Passenger fromDto(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        PassengerAdapter.fromDto(passengerDto, passenger);

        return passenger;
    }

    public final static Passenger fromDto(PassengerDto passengerDto, Passenger passenger) {
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setAge(passengerDto.getAge());
        passenger.setBirthdayDate(passengerDto.getBirthdayDate());
        passenger.setGender(passengerDto.getGender());
        passenger.setCnp(passengerDto.getCnp());
        passenger.setPhoneNumber(passengerDto.getPhoneNumber());
        passenger.setEmailAddress(passengerDto.getEmailAddress());
        passenger.setNationality(passengerDto.getNationality());

        return passenger;
    }
}
