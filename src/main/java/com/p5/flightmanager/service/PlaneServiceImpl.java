package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PlanesRepository;
import com.p5.flightmanager.repository.models.Plane;
import com.p5.flightmanager.service.api.PlaneService;
import com.p5.flightmanager.service.dto.PlaneAdapter;
import com.p5.flightmanager.service.dto.PlaneDto;
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
    private PlanesRepository planesRepository;

    @Override
    public List<PlaneDto> getAll(String search) {
        return PlaneAdapter.toListDto(planesRepository.filterByModel(search));
    }

    @Override
    public PlaneDto createPlane(PlaneDto planeDto) {
        Plane plane = null;
        if (isValidPlane(planeDto)) {
            plane = planesRepository.save(PlaneAdapter.fromDto(planeDto));
        } else {
            throw new EmptyFieldException();
        }
        return PlaneAdapter.toDto(plane);
    }

    @Override
    public PlaneDto getById(String id) {
        Optional<Plane> optionalPlane = planesRepository.findById(UUID.fromString(id));
        if (optionalPlane.isPresent()) {
            Plane plane = optionalPlane.get();
            return PlaneAdapter.toDto(plane);
        }
        throw new NoPlaneException();
    }

    @Override
    public PlaneDto updatePlane(PlaneDto planeDto) {
        Optional<Plane> optionalPlane = planesRepository.findById(UUID.fromString(planeDto.getId()));
        if (optionalPlane.isPresent()) {
            Plane plane = optionalPlane.get();
            plane = PlaneAdapter.fromDto(planeDto, plane);
            planesRepository.save(plane);
            return PlaneAdapter.toDto(plane);
        }
        throw new NoPlaneException();
    }

    @Override
    public void deletePlane(String id) {
        Optional<Plane> optionalPlane = planesRepository.findById(UUID.fromString(id));
        if (optionalPlane.isPresent()) {
            Plane plane = optionalPlane.get();
            planesRepository.delete(plane);
        }
    }

    private boolean isValidPlane(PlaneDto planeDto) {
        if (planeDto.getModel() == null || planeDto.getModel().isEmpty()) {
            return false;
        }
        return true;
    }

}
