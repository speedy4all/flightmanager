package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirplanesRepository;
import com.p5.flightmanager.repository.models.Airplanes;
import com.p5.flightmanager.service.api.AiplaneService;
import com.p5.flightmanager.service.dto.adapter.AirplaneAdapter;
import com.p5.flightmanager.service.dto.AirplaneDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoPlaneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AiplaneServiceImpl implements AiplaneService {

    @Autowired
    private AirplanesRepository airplanesRepository;

    @Override
    public List<AirplaneDto> getAll(String search) {
        return AirplaneAdapter.toListDto(airplanesRepository.filterByModel(search));
    }

    @Override
    public AirplaneDto createPlane(AirplaneDto airplaneDto) {
       Airplanes airplanes = null;
       if(isValidPlane(airplaneDto)) {
           airplanes = airplanesRepository.save(AirplaneAdapter.fromDto(airplaneDto));
       }
       else {
           throw new EmptyFieldException();
       }
       return AirplaneAdapter.toDto(airplanes);
    }

    @Override
    public AirplaneDto getById(String id) {
       Optional<Airplanes> optionalPlane = airplanesRepository.findById(UUID.fromString(id));
       if(optionalPlane.isPresent()) {
           Airplanes airplanes = optionalPlane.get();
           return AirplaneAdapter.toDto(airplanes);
       }
       throw new NoPlaneException();
    }

    @Override
    public AirplaneDto updatePlane(AirplaneDto airplaneDto) {
        Optional<Airplanes> optionalPlane = airplanesRepository.findById(UUID.fromString(airplaneDto.getId()));
        if(optionalPlane.isPresent()) {
            Airplanes airplanes = optionalPlane.get();
            airplanes = AirplaneAdapter.fromDto(airplaneDto, airplanes);
            airplanesRepository.save(airplanes);
            return AirplaneAdapter.toDto(airplanes);
        }
        throw new NoPlaneException();
    }

    @Override
    public void deletePlane(String id) {
        Optional<Airplanes> optionalPlane = airplanesRepository.findById(UUID.fromString(id));
        if(optionalPlane.isPresent()) {
            Airplanes airplanes = optionalPlane.get();
            airplanesRepository.delete(airplanes);
        }
    }

    private boolean isValidPlane(AirplaneDto airplaneDto) {
        if(airplaneDto.getModel() == null || airplaneDto.getModel().isEmpty()) {
            return false;
        }
        return true;
    }

}
