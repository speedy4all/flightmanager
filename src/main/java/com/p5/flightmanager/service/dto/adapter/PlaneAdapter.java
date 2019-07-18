package com.p5.flightmanager.service.dto.adapter;

import java.util.ArrayList;
import java.util.List;

public class PlaneAdapter {
    public static final PlaneDto toDto(Plane plane) {
        PlaneDto planeDto = new PlaneDto();

        planeDto.setId(plane.getId().toString());
        planeDto.setName(plane.getName());
        planeDto.setNumberOfSeats(plane.getNumberOfSeats());

        return planeDto;
    }

    public final static List<PlaneDto> toListDto(Iterable<Plane> planeList){
        List<PlaneDto> planeDtos = new ArrayList<>();
        planeList.forEach(passenger -> planeDtos.add(toDto(passenger)));

        return planeDtos;
    }

    public static final Plane fromDto(PlaneDto planeDto){
        Plane plane = new Plane();
        return fromDto(planeDto, plane);
    }

    public static final Plane fromDto(PlaneDto planeDto, Plane plane){
        plane.setName(planeDto.getName());
        plane.setNumberOfSeats(planeDto.getNumberOfSeats());

        return plane;
    }
}
