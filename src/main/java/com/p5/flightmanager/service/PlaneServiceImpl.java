package com.p5.flightmanager.service;



import com.p5.flightmanager.repository.PlaneRepository;

import com.p5.flightmanager.repository.models.Plane;

import com.p5.flightmanager.service.api.PlaneService;

import com.p5.flightmanager.service.dto.PlaneAdapter;

import com.p5.flightmanager.service.dto.PlaneDto;

import com.p5.flightmanager.service.exceptions.EmptyFieldException;

import com.p5.flightmanager.service.exceptions.NoPlaneException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;



import java.util.List;

import java.util.Optional;

import java.util.UUID;



@Component

public class PlaneServiceImpl implements PlaneService {



    @Autowired

    private PlaneRepository planesRepository;



    @Override

    public List<PlaneDto> getAll(String search) {

        return PlaneAdapter.toListDto(planesRepository.filterByName(search));

    }



    @Override

    public PlaneDto createPlane(PlaneDto planeDto) {

        Plane plane = null;

        if(isValidPlane(planeDto)){

            plane = planesRepository.save(PlaneAdapter.fromDto(planeDto));

        } else {

            throw new EmptyFieldException();

        }



        return PlaneAdapter.toDto(plane);

    }



    public boolean isValidPlane(PlaneDto planeDto){

        if(planeDto.getCompanyName() == null || planeDto.getCompanyName().isEmpty())

            return false;

        throw new NoPlaneException();

    }



    @Override

    public PlaneDto getById(String id) {

        Optional<Plane> optional = planesRepository.findById(UUID.fromString(id));

        if(optional.isPresent())

        {

            return PlaneAdapter.toDto(optional.get());

        }

        throw new NoPlaneException();

    }



    @Override

    public PlaneDto updatePlane(PlaneDto passengerDto) {

        Optional<Plane> optionalPassenger = planesRepository.findById(UUID.fromString(passengerDto.getId()));

        if(optionalPassenger.isPresent()){

            Plane plane = optionalPassenger.get();

            planesRepository.save(PlaneAdapter.fromDto(passengerDto,plane));

            return PlaneAdapter.toDto(PlaneAdapter.fromDto(passengerDto,plane));

        }

        throw new NoPlaneException();

    }



    @Override

    public void deletePlane(String planeID) {

        Optional<Plane> optionalPlane = planesRepository.findById(UUID.fromString(planeID));

        if(optionalPlane.isPresent()){

            Plane plane = optionalPlane.get();

            planesRepository.delete(plane);

        } else

        {

            throw new NoPlaneException();

        }

    }

}