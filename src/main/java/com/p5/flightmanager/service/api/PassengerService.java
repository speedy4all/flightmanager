package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {
    List<PassengerDto> getAll(String search);

    PassengerDto createPassager(PassengerDto passengerDto);

    PassengerDto getById(String id);

    PassengerDto updatePassager(PassengerDto passengerDto);

    void deletePassager(String id);
}
