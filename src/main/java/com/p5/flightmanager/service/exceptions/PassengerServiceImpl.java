package com.p5.flightmanager.service.exceptions;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.PassengerAdapter;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassengerServiceImpl implements PassengerService {


    @Autowired
     private PassengerRepository passengerRepository;


    public List<PassengerDto> getAll(String search){
      return PassengerAdapter.toListDto(passengerRepository.filterByName(search));

    }
    @Override
    public PassengerDto createPassager(PassengerDto passengerDto){
        Passenger passenger =null;
        if (isValidPassager(passengerDto)){
            passenger = passengerRepository.save(PassengerAdapter.fromDto(passengerDto));

        }
        else{
            throw new EmptyFieldException();

        }
        return PassengerAdapter.toDto(passenger);

    }

    private boolean isValidPassager(PassengerDto passengerDto) {
        if(passengerDto.getNpc().chars().count() !=13){
    return false;
        }
        if (passengerDto.getName().isEmpty()){
            return false;
        }
        if (passengerDto.getBirthdate()==null){
            return false;
        }
    return true;
        }


    @Override
    public PassengerDto updatePassager(PassengerDto passengerDto) {
        Optional<Passenger> optionalPassager = passengerRepository.findById(UUID.fromString(passengerDto.getName()));
        if (optionalPassager.isPresent()) {
            Passenger passenger = optionalPassager.get();
            passenger = PassengerAdapter.fromDto(passengerDto, passenger);
            passengerRepository.save(passenger);
            return PassengerAdapter.toDto(passenger);
        }
        throw new NoPassengerException();
    }


    @Override
    public PassengerDto getById(String id) {
        Optional<Passenger> optionalPassager = passengerRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Passenger passsager = optionalPassager.get();
            return PassengerAdapter.toDto(passsager);
        }
        throw new NoPassengerException();
    }

    @Override
    public void deletePassager(String id){
        Optional<Passenger>optionalPassager= passengerRepository.findById(UUID.fromString(id));
        if (optionalPassager.isPresent()){
            Passenger passenger =optionalPassager.get();
            passengerRepository.delete(passenger);
        }



    }









}

