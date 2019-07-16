package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Airplane;
import com.p5.flightmanager.repository.AirplanesRepository;
import com.p5.flightmanager.service.api.AirplaneService;
import com.p5.flightmanager.service.dto.AirplaneDto;
import com.p5.flightmanager.service.dto.AirplaneAdapter;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoAirplaneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplanesRepository airplanesRepository;

    public List<AirplaneDto> getAll(String search) {

        return AirplaneAdapter.toListDto(airplanesRepository.filterByName(search));
    }

    @Override
    public AirplaneDto createAirplane(AirplaneDto airplaneDto) {

        Airplane airplane = null;
        //Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        if(isValidAirplane(airplaneDto)) {
            airplane = airplanesRepository.save(AirplaneAdapter.fromDto(airplaneDto));
        } else {
            throw new EmptyFieldException();

        }
        return AirplaneAdapter.toDto(airplane);
    }

    @Override
    public AirplaneDto updateAirplane(AirplaneDto airplaneDto) {
        Optional<Airplane> optionalAirplane = airplanesRepository.findById(UUID.fromString(airplaneDto.getId()));
        if(optionalAirplane.isPresent()) {

            Airplane airplane = optionalAirplane.get();
            airplane = AirplaneAdapter.fromDto(airplaneDto, airplane);
            airplanesRepository.save(airplane);
            return AirplaneAdapter.toDto(airplane);
        }
        throw new NoAirplaneException();
    }

    @Override
    public AirplaneDto getById(String id) {
        Optional<Airplane> optionalAirplane = airplanesRepository.findById(UUID.fromString(id));
        if(optionalAirplane.isPresent()) {
            Airplane airplane = optionalAirplane.get();
            return AirplaneAdapter.toDto(airplane);
        }
        throw new NoAirplaneException();
    }

    @Override
    public void deleteAirplane(String id) {
        Optional<Airplane> optionalAirplane = airplanesRepository.findById(UUID.fromString(id));
        if(optionalAirplane.isPresent()) {
            Airplane airplane = optionalAirplane.get();
            airplanesRepository.delete(airplane);
        }
    }

    private  boolean isValidAirplane(AirplaneDto airplaneDto) {
        if(airplaneDto.getName() == null || airplaneDto.getName().isEmpty())
            return false;
        if(airplaneDto.getNumberOfSeats() == null)
            return false;

        return true;
    }
}
