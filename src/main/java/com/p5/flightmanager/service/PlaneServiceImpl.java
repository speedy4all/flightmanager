package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PlanesRepository;
import com.p5.flightmanager.repository.models.Plane;
import com.p5.flightmanager.service.api.PlaneService;
import com.p5.flightmanager.service.dto.PlaneAdapter;
import com.p5.flightmanager.service.dto.PlaneDto;
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
    public PlaneDto createPlane(PlaneDto planeDto) {

        Plane plane = PlaneAdapter.fromDto(planeDto);
        planesRepository.save(plane);
        return PlaneAdapter.toDto(plane);
    }

    @Override
    public List<PlaneDto> getAll(String search) {
        return PlaneAdapter.toListDto(planesRepository.filterByName(search));
    }

    @Override
    public PlaneDto getById(String id) {
        Optional<Plane> optional = planesRepository.findById(UUID.fromString(id));
        if(optional.isPresent())
        {
            return PlaneAdapter.toDto(optional.get());
        }
        return null;
    }

    @Override
    public PlaneDto updatePlane(PlaneDto passengerDto) {
        Optional<Plane> optionalPassenger = planesRepository.findById(UUID.fromString(passengerDto.getId()));
        if(optionalPassenger.isPresent()){
            Plane plane = optionalPassenger.get();
            planesRepository.save(PlaneAdapter.fromDto(passengerDto,plane));
            return PlaneAdapter.toDto(PlaneAdapter.fromDto(passengerDto,plane));
        }
        return null;
    }

    @Override
    public void deletePlane(String planeID) {
        Optional<Plane> optionalPlane = planesRepository.findById(UUID.fromString(planeID));
        if(optionalPlane.isPresent()){
            Plane plane = optionalPlane.get();
            planesRepository.delete(plane);
        }
    }
}
