package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.AirplaneDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AiplaneService {

    List<AirplaneDto> getAll(String search);

    AirplaneDto createPlane(AirplaneDto airplaneDto);

    AirplaneDto getById(String id);

    AirplaneDto updatePlane(AirplaneDto airplaneDto);

    void deletePlane(String id);

}
