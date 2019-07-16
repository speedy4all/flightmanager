package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneAdapter {

    public final static PlaneDto toDto(Plane plane) {
        PlaneDto planeDto = new PlaneDto();

        planeDto.setId(plane.getId().toString());
        planeDto.setName(plane.getName());
        planeDto.setCode(plane.getCode());
        planeDto.setAltitude(plane.getAltitude());
        planeDto.setModel(plane.getModel());
        planeDto.setPassengersCapacity(plane.getPassengersCapacity());
        planeDto.setFuelCapacity(plane.getFuelCapacity());

        return planeDto;

    }

    public final static Plane fromDto(PlaneDto planeDto)
    {
        Plane plane = new Plane();
        fromDto(planeDto,plane);

        return plane;
    }

    public final static Plane fromDto(PlaneDto planeDto, Plane plane) {
        plane.setName(planeDto.getName());
        plane.setCode(planeDto.getCode());
        plane.setAltitude(planeDto.getAltitude());
        plane.setModel(planeDto.getModel());
        plane.setPassengersCapacity(planeDto.getPassengersCapacity());
        plane.setFuelCapacity(planeDto.getFuelCapacity());
        return plane;
    }

    public final static List<PlaneDto> toListDto(Iterable<Plane> planeList) {
        List<PlaneDto> listDto = new ArrayList<>();
        planeList.forEach(passenger -> listDto.add(toDto(passenger)));

        return listDto;
    }


}
