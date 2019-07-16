package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {

    List<PassengerDto> getAll(String firstName);

    PassengerDto createPassenger(PassengerDto passengerDto);
}
