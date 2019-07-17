package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirplaneRepository;
import com.p5.flightmanager.repository.models.Airplane;
import com.p5.flightmanager.service.api.AirplaneService;
import com.p5.flightmanager.service.dto.adapter.AirplaneAdapter;
import com.p5.flightmanager.service.dto.AirplaneDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoAirplaneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public List<AirplaneDto> getAll(String search) {
        return AirplaneAdapter.toListDto(airplaneRepository.filterByName(search));
    }

    @Override
    public AirplaneDto createAirplane(AirplaneDto airplaneDto) {
        Airplane airplane = null;
        if(isValidAirplane(airplaneDto)) {
            airplane = airplaneRepository.save(AirplaneAdapter.fromDto(airplaneDto));
        } else {
            throw new EmptyFieldException();
        }
        return AirplaneAdapter.toDto(airplane);
    }

    @Override
    public AirplaneDto getById(String id) {
        Optional<Airplane> optionalAirplane = airplaneRepository.findById(UUID.fromString(id));
        if(optionalAirplane.isPresent()) {
            Airplane airplane = optionalAirplane.get();
            return AirplaneAdapter.toDto(airplane);
        }
        throw new NoAirplaneException();
    }

    @Override
    public AirplaneDto updateAirplane(AirplaneDto airplaneDto) {
        Optional<Airplane> optionalAirplane = airplaneRepository.findById(UUID.fromString(airplaneDto.getId()));
        if(optionalAirplane.isPresent()) {
            Airplane airplane = optionalAirplane.get();
            airplane = AirplaneAdapter.fromDto(airplaneDto, airplane);
            airplaneRepository.save(airplane);
            return AirplaneAdapter.toDto(airplane);
        }
        throw new NoAirplaneException();
    }

    @Override
    public void deleteAirplane(String id) {
        Optional<Airplane> optionalAirplane = airplaneRepository.findById(UUID.fromString(id));
        if(optionalAirplane.isPresent()) {
            Airplane airplane = optionalAirplane.get();
            airplaneRepository.delete(airplane);
        }
    }

    private boolean isValidAirplane(AirplaneDto airplaneDto){
        if(StringUtils.isEmpty(airplaneDto.getName())){
            return false;
        }
        return true;
    }
}
