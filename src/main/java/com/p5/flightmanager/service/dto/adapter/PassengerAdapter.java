package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.dto.PassengerDto;

import java.util.ArrayList;
import java.util.List;

public class PassengerAdapter {

    public final static List<PassengerDto> toListDto(Iterable<Passenger> passengerList) {
        List<PassengerDto> listDto = new ArrayList<>();
        passengerList.forEach(passenger -> listDto.add(toDto(passenger)));

        return listDto;
    }

    public final static PassengerDto toDto(Passenger passenger){
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setId(passenger.getId().toString());
        passengerDto.setDateOfBirth(passenger.getDateOfBirth());
        passengerDto.setEmail(passenger.getEmail());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setGender(passenger.getGender());
        passengerDto.setLanguage(passenger.getLanguage());
        passengerDto.setLastName(passenger.getLastName());
        passengerDto.setMobileNumber(passenger.getMobileNumber());
        passengerDto.setPersonalIdentifierCode(passenger.getPersonalIdentificationCode());
        return passengerDto;
    }

    public final static Passenger fromDto(PassengerDto passengerDto){
        Passenger passenger = new Passenger();
        passenger = PassengerAdapter.fromDto(passengerDto,passenger);
        return passenger;
    }

    public final static Passenger fromDto(PassengerDto passengerDto, Passenger passenger){
        passenger.setDateOfBirth(passengerDto.getDateOfBirth());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setGender(passengerDto.getGender());
        passenger.setLanguage(passengerDto.getLanguage());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setMobileNumber(passengerDto.getMobileNumber());
        passenger.setPersonalIdentifierCode(passengerDto.getPersonalIdentificationCode());
        return passenger;
    }
}
