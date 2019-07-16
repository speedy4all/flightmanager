package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassagersRepository;
import com.p5.flightmanager.repository.models.Passager;
import com.p5.flightmanager.service.api.PassagerService;
import com.p5.flightmanager.service.dto.PassagerDto;
import com.p5.flightmanager.service.dto.adapter.PassagerAdapter;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoPassagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PassagerServiceImpl implements PassagerService {

    @Autowired
    private PassagersRepository passagersRepository;

    @Override
    public List<PassagerDto> getAll(String search) {
        if (search == null){
            search = "";
        }

        return PassagerAdapter.toListDto(passagersRepository.filterByName(search.toLowerCase()));
    }

    @Override
    public PassagerDto createPassager(PassagerDto passagerDto) {
        Passager passager;
        if (isValidPassager(passagerDto)){
            passager = passagersRepository.save(PassagerAdapter.fromDto(passagerDto));
        } else {
            // change exception here
            throw new EmptyFieldException();
        }

        return PassagerAdapter.toDto(passager);
    }

    @Override
    public PassagerDto getById(String id) {
        Optional<Passager> optionalPassager = passagersRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Passager passager = optionalPassager.get();

            return PassagerAdapter.toDto(passager);
        }

        throw new NoPassagerException();
    }

    @Override
    public PassagerDto updatePassager(PassagerDto passagerDto) {
        Optional<Passager> optionalPassager = passagersRepository.findById(UUID.fromString(passagerDto.getId()));
        Passager passager;

        if(optionalPassager.isPresent()) {
            passager = passagersRepository.save(PassagerAdapter.fromDto(passagerDto, optionalPassager.get()));
        } else {
            throw new EmptyFieldException();
        }

        return PassagerAdapter.toDto(passager);
    }

    @Override
    public void deletePassager(String id) {
        Optional<Passager> optionalPassager = passagersRepository.findById(UUID.fromString(id));
        if(optionalPassager.isPresent()) {
            Passager passager = optionalPassager.get();
            passagersRepository.delete(passager);
        } else {
            throw new NoPassagerException();
        }
    }

    private boolean isValidPassager(PassagerDto passager){
        if (passager.getNpc().chars().count() != 13){
            return false;
        }
        if (passager.getFirstName().isEmpty() || passager.getLastName().isEmpty()){
            return false;
        }
        if (passager.getBirthDate() == null){
            return false;
        }

        return true;
    }

    public static final int calculateAge(Date birthDate, Date currentDate){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        return (d2 - d1) / 10000;
    }
}
