package com.p5.flightmanager.service.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengersService {
    List<PassengersDto> getAll(String search);

    PassengersDto createPassager(PassengersDto passengersDto);

    PassengersDto getById(String id);

    PassengersDto updatePassager(PassengersDto passengersDto);

    void deletePassager(String id);
}
