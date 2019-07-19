package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.PassengerServiceImpl;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class PassengerAdapter {

    public final static PassengerDto toDto (Passenger passenger){
        PassengerDto passengerDto = new PassengerDto();

        passengerDto.setId(passenger.getId().toString());
        passengerDto.setAge(PassengerServiceImpl.calculateAge(passenger.getBirthdayDate()));
        passengerDto.setBirthdayDate(passenger.getBirthdayDate());
        passengerDto.setCountry(passenger.getCountry());
        passengerDto.setEmail(passenger.getEmail());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setLastName(passenger.getLastName());
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
        passenger.setBirthdayDate(passengerDto.getBirthdayDate());
        passenger.setCountry(passengerDto.getCountry());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setIdentifyNumber(passengerDto.getIdentifyNumber());
        passenger.setPhoneNumber(passengerDto.getPhoneNumber());
        passenger.setSex(passengerDto.getSex());

        return passenger;
    }
}
