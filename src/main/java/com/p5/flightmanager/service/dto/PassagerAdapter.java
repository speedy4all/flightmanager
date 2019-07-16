package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.Passager;

import java.util.ArrayList;
import java.util.List;

public class PassagerAdapter {

    public final static PassagerDto toDto(Passager passager){
        PassagerDto passagerDto=new PassagerDto();
        passagerDto.setName(passager.getName());
        passagerDto.setBirthdate(passager.getBirthDate());
        passagerDto.setNpc(passager.getNpc());

       return passagerDto;
    }

    public final static Passager fromDto(PassagerDto passagerDto){
        Passager passager=new Passager();
        PassagerAdapter.fromDto(passagerDto,passager);
        return passager;


    }
    public final static Passager fromDto(PassagerDto passagerDto,Passager passager){
        passager.setName(passagerDto.getName());
        passager.setBirthDate(passagerDto.getBirthdate());
        passager.setNpc(passagerDto.getNpc());
        return passager;



    }

    public static List<PassagerDto> toListDto(Iterable<Passager> passagerList) {
        List<PassagerDto>listDto=new ArrayList<>();
        passagerList.forEach(passager->listDto.add(toDto(passager)));
        return listDto;

    }
}
