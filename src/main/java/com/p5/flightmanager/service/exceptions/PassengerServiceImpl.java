package com.p5.flightmanager.service.exceptions;

import com.p5.flightmanager.repository.models.PassengerRepository;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengerServiceImpl implements PassengerService {
@Autowired
private PassengerRepository passengerRepository;

    @Override
    public List<PassengerDto> getAll(String search) {
        return null;
    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {
        return null;
    }

    @Override
    public PassengerDto getById(String id) {
        return null;
    }

    @Override
    public PassengerDto updatePassenger(PassengerDto passengerDto) {
        return null;
    }

    @Override
    public void deletePassenger(String id) {

    }


}
