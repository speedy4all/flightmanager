package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.PassengerDto;

import java.util.List;

public interface PassengerService {
    List<PassengerDto> getAll(String search);
    PassengerDto createPassager(PassengerDto passengerDto);
    PassengerDto updatePassager(PassengerDto passengerDto);
    void deletePassager(String id);
    PassengerDto getById(String id);


}
