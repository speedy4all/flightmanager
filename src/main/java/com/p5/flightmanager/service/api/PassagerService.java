package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.PassagerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassagerService {
    List<PassagerDto> getAll(String search);

    PassagerDto createPassager(PassagerDto passagerDto);

    PassagerDto getById(String id);

    PassagerDto updatePassager(PassagerDto passagerDto);

    void deletePassager(String id);
}
