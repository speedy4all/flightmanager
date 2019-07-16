package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.PassengerAdapter;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<PassengerDto> getAll(String firstName) {
        return PassengerAdapter.toListDto(passengerRepository.filterByName(firstName));
    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {
        Passenger passenger = null;
        if(isValidPassenger(passengerDto))
            passenger = passengerRepository.save(PassengerAdapter.fromDto(passengerDto));

        return PassengerAdapter.toDto(passenger);
    }

    private boolean isValidPassenger(PassengerDto passengerDto) {
        if(passengerDto.getFirstName() == null || passengerDto.getFirstName().isEmpty())
            return false;
        if(passengerDto.getLastName() == null || passengerDto.getLastName().isEmpty())
            return false;
        return true;
    }


}
