package com.p5.flightmanager.service.exceptions;

import com.p5.flightmanager.repository.Passager;
import com.p5.flightmanager.repository.PassagerRepository;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.api.PassagerService;
import com.p5.flightmanager.service.dto.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.PassagerAdapter;
import com.p5.flightmanager.service.dto.PassagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassagerServiceImpl implements PassagerService{


    @Autowired
     private PassagerRepository passagerRepository;


    public List<PassagerDto> getAll(String search){
      return PassagerAdapter.toListDto(passagerRepository.filterByName(search));

    }
    @Override
    public PassagerDto createPassager(PassagerDto passagerDto){
        Passager passager=null;
        if (isValidPassager(passagerDto)){
            passager=passagerRepository.save(PassagerAdapter.fromDto(passagerDto));

        }
        else{
            throw new EmptyFieldException();

        }
        return PassagerAdapter.toDto(passager);

    }

    private boolean isValidPassager(PassagerDto passagerDto) {
        if(passager.getNpc().chars().count() !=13){
    return false;
        }
        if (passager.getName().isEmpty()){
            return false;
        }
        if (passager.getBirthdate()==null){
            return false;
        }
    return true;
        }

    }

    @Override
    public PassagerDto updatePassager(PassagerDto passagerDto) {
        Optional<Passager> optionalPassager = passagerRepository.findById(UUID.fromString(passagerDto.getId()));
        if (optionalPassager.isPresent()) {
            Passager passager = optionalPassager.get();
            passager = PassagerAdapter.fromDto(passagerDto, passager);
            passagerRepository.save(passager);
            return PassagerAdapter.toDto(passager);
        }
        throw new NoPassagerException();
    }


    @Override
    public PassagerDto getById(String id) {
        Optional<Passager> optionalPassager = passagerRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Passager passsager = optionalPassager.get();
            return PassagerAdapter.toDto(passager);
        }
        throw new NoPassagerException();
    }

    @Override
    public void deletePassager(String id){
        Optional<Passager>optionalPassager=passagerRepository.findById(UUID.fromString(id));
        if (optionalPassager.isPresent()){
            Passager passager=optionalPassager.get();
            passagerRepository.delete(passager);
        }



    }









}

