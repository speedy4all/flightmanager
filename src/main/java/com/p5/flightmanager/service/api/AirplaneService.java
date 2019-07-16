package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.AirplaneDto;
import com.p5.flightmanager.service.dto.AirportDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirplaneService {

    List<AirplaneDto> getAll(String search);

    AirplaneDto createAirplane(AirplaneDto airplaneDto);

    AirplaneDto getById(String id);

    AirportDto updateAirplane(AirplaneDto airplaneDto);

    void deleteAirplane(String id);
}
