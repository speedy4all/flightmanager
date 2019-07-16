package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PassengersAdapter {

    public final static PassengersDto toDto(Passenger passengers) {
        PassengersDto passengerDto = new PassengerDto();
        passengerDto.setN(passengers.getName());
        passengerDto.setSurname(passengers.getSurname());
        passengerDto.setFullname(passengers.getName().concat("-").concat(passengers.getSurname()));
        passengerDto.setNationality(passengers.getNationality());
        passengerDto.setAge(passengers.getAge());
        passengerDto.setGender(passengers.getGender());
        passengerDto.setPhonenumber(passengers.getPhonenumber());
        passengerDto.setEmailadress(passengers.getEmailadress());
        passengerDto.setPersonalidentifier(passengers.getPersonalidentifier());
        passengerDto.setBirthdate(passengers.getBirthdate());



        return passengerDto;
    }

    public final static List<PassengerDto> toListDto(Iterable<Passengers> passengerList) {
        List<PassengerDto> listDto = new ArrayList<>();
        passengerList.forEach(passengers -> listDto.add(toDto(passengers)));

        return listDto;
    }

    public final static Passengers fromDto(PassengerDto passengerDto) {
        Passengers passengers = new Passengers();
        fromDto(passengerDto, passengers);
        return passengers;

    }

    public final static Passengers fromDto(PassengerDto passengerDto, Passengers passengers)
    {
        if(!passengerDto.getId().isEmpty() || passengerDto.getId() != null) {
            passengers.setId(UUID.fromString(passengerDto.getId()));
        }
        passengers.setName(passengerDto.getName());
        passengers.setSurname(passengerDto.getSurname());
        passengers.setFullname(passengerDto.getName().concat("-").concat(passengers.getSurname()));
        passengers.setNationality(passengerDto.getNationality());
        passengers.setAge(passengerDto.getAge());
        passengers.setGender(passengerDto.getGender());
        passengers.setPhonenumber(passengerDto.getPhonenumber());
        passengers.setEmailadress(passengerDto.getEmailadress());
        passengers.setPersonalidentifier(passengerDto.getPersonalidentifier());
        passengers.setBirthdate(passengerDto.getBirthdate());
        return passengers;

    }
}
