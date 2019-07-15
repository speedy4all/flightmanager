package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {
    List<PassengerDto> getAll (String search);

    PassengerDto createPassenger(PassengerDto passengerDto);

    PassengerDto getById(String id);

    PassengerDto updatePassenger(PassengerDto passengerDto);

    void deletePassenger(String id);


}
