package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PlaneRepository;
import com.p5.flightmanager.repository.models.Plane;
import com.p5.flightmanager.service.api.PlaneService;
import com.p5.flightmanager.service.dto.PlaneDto;
import com.p5.flightmanager.service.dto.adapter.PlaneAdapter;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoPlaneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    private PlaneRepository planeRepository;


    @Override
    public List<PlaneDto> getAll(String search) {
        if (search == null) {
            search = "";
        }

        return PlaneAdapter.toListDto(planeRepository.filterByName(search.toLowerCase()));
    }

    @Override
    public PlaneDto createPlane(PlaneDto planeDto) {
        Plane plane;
        if (isValidPlane(planeDto)) {
            plane = planeRepository.save(PlaneAdapter.fromDto(planeDto));
        } else {
            // change exception here
            throw new EmptyFieldException();
        }

        return PlaneAdapter.toDto(plane);
    }

    @Override
    public PlaneDto getById(String id) {
        Optional<Plane> optionalPlane = planeRepository.findById(UUID.fromString(id));
        if(optionalPlane.isPresent()) {
            Plane plane = optionalPlane.get();

            return PlaneAdapter.toDto(plane);
        }

        throw new NoPlaneException();
    }

    @Override
    public PlaneDto updatePlane(PlaneDto planeDto) {
        Optional<Plane> optionalPlane = planeRepository.findById(UUID.fromString(planeDto.getId()));
        Plane plane;

        if(optionalPlane.isPresent()) {
            plane = planeRepository.save(PlaneAdapter.fromDto(planeDto, optionalPlane.get()));
        } else {
            throw new EmptyFieldException();
        }

        return PlaneAdapter.toDto(plane);
    }

    @Override
    public void deletePlane(String id) {
        Optional<Plane> optionalPassager = planeRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Plane plane = optionalPassager.get();
            planeRepository.delete(plane);
        } else {
            throw new NoPlaneException();
        }
    }

    private boolean isValidPlane(PlaneDto passager) {

        return true;
    }
}
