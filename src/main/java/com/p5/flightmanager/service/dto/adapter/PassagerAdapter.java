package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Passager;
import com.p5.flightmanager.service.dto.PassagerDto;

import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PassagerAdapter {
    public static final PassagerDto toDto(Passager passager){
        PassagerDto passagerDto = new PassagerDto();

        passagerDto.setBirthDate(passager.getBirthDate());
        passagerDto.setFirstName(passager.getFirstName());
        passagerDto.setLastName(passager.getLastName());
        passagerDto.setId(passager.getId().toString());
        //passagerDto.setAge(new Date().getYear() - passager.getBirthDate().getYear());

        return passagerDto;
    }

    public final static List<PassagerDto> toListDto(Iterable<Passager> passagerList){
        List<PassagerDto> passagersDto = new ArrayList<>();
        passagerList.forEach(passager -> passagersDto.add(toDto(passager)));

        return passagersDto;
    }

    public static final Passager fromDto(PassagerDto passagerDto) {
        Passager passager = new Passager();
        return fromDto(passagerDto, passager);
    }

    public static final Passager fromDto(PassagerDto passagerDto, Passager passager){
        passager.setBirthDate(passagerDto.getBirthDate());
        passager.setFirstName(passagerDto.getFirstName());
        passager.setLastName(passagerDto.getLastName());

        return passager;
    }
}
