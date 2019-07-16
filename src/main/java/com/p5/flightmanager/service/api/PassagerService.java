package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.PassagerDto;

import java.util.List;

public interface PassagerService {
    List<PassagerDto> getAll(String search);
    PassagerDto createPassager(PassagerDto passagerDto);
    PassagerDto updatePassager(PassagerDto passagerDto);
    void deletePassager(PassagerDto passagerDto);
    PassagerDto getById(String id);


}
