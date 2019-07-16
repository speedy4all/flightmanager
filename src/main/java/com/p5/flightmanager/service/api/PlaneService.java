package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.PlaneDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaneService {
    List<PlaneDto> getAll(String search);

    PlaneDto createPlane(PlaneDto flightDto);

    PlaneDto getById(String id);

    PlaneDto updatePlane(PlaneDto flightDto);

    void deletePlane(String id);
}
