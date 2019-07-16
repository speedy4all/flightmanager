package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.dto.PassengerDto;

import java.util.ArrayList;
import java.util.List;

public class PassengerAdapter {

    public final static PassengerDto toDto(Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setId(passenger.getId().toString());
        passengerDto.setDateOfBirth(passenger.getDateOfBirth());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setFullPassengerName(passenger.getFirstName().concat(" ").concat(passenger.getLastName()));
        passengerDto.setGender(passenger.getGender());
        passengerDto.setIdentificationCardNumber(passenger.getIdentificationCardNumber());
        passengerDto.setIssueDate(passenger.getIssueDate());
        passengerDto.setLanguage(passenger.getLanguage());
        passengerDto.setLastName(passenger.getLastName());
        passengerDto.setMobileNumber(passenger.getMobileNumber());
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
        passenger.setDateOfBirth(passengerDto.getDateOfBirth());
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setGender(passengerDto.getGender());
        passenger.setIdentificationCardNumber(passengerDto.getIdentificationCardNumber());
        passenger.setIssueDate(passengerDto.getIssueDate());
        passenger.setLanguage(passengerDto.getLanguage());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setMobileNumber(passengerDto.getMobileNumber());
        passenger.setNationality(passengerDto.getNationality());

        return passenger;
    }
}
