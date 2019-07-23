package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PassengerAdapter {

    public final static PassengerDto toDto(Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto();

        passengerDto.setId(passenger.getId().toString());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setLastName(passenger.getLastName());
        passengerDto.setBornDate(passenger.getBornDate());
        passengerDto.setPersonalID(passenger.getpersonalID());
        passengerDto.setEmail(passenger.getEmail());
        passengerDto.setNationality(passenger.getNationality());
        passengerDto.setPhoneNumber(passenger.getPhoneNumber());
        passengerDto.setTitle(passenger.getTitle());
        if(!StringUtils.isEmpty(passenger.getFirstName()) && !StringUtils.isEmpty(passenger.getLastName())) {
            passengerDto.setFullName(passenger.getFirstName().concat("-").concat(passenger.getLastName()));
        }
        return passengerDto;
    }

    public final static Passenger fromDto(PassengerDto passengerDto)
    {
        Passenger passenger = new Passenger();
        fromDto(passengerDto,passenger);

        return passenger;
    }

    public final static Passenger fromDto(PassengerDto passengerDto, Passenger passenger)
    {
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setBornDate(passengerDto.getBornDate());
        passenger.setpersonalID(passengerDto.getPersonalID());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setNationality(passengerDto.getNationality());
        passenger.setPhoneNumber(passengerDto.getPhoneNumber());
        passenger.setTitle(passengerDto.getTitle());

        return passenger;
    }

    public final static List<PassengerDto> toListDto(Iterable<Passenger> passengerList) {
        List<PassengerDto> listDto = new ArrayList<>();
        passengerList.forEach(passenger -> listDto.add(toDto(passenger)));

        return listDto;
    }
}
