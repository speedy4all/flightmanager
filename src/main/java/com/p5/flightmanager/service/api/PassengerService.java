package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {

    List<PassengerDto> getAll(String search);

    PassengerDto createPassenger(PassengerDto flightDto);

    PassengerDto getById(String id);

    PassengerDto updatePassenger(PassengerDto flightDto);

    void deletePassenger(String id);

    Passenger getOrCreate(String uniqueIdentifier, String name);
}