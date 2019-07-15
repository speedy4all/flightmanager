package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Passenger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PassengerAdapter {

    public final static PassengerDto toDto (Passenger passenger){


        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setName(passenger.getName());
        passengerDto.setHomeAdress(passenger.getHomeAdress());
        passengerDto.setPhoneNumber(passenger.getPhoneNumber());
        passengerDto.setBirthDate(passenger.getBirthDate());
        passengerDto.setIdentify_number(passenger.getIdentify_number());
        passengerDto.setFlightNumber(passenger.getFlightNumber());

        return passengerDto;
    }
}
