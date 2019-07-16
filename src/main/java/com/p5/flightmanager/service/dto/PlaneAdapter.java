package com.p5.flightmanager.service.dto;

import com.p5.flightmanager.repository.models.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneAdapter {

    public final static PlaneDto toDto(Plane plane) {
        PlaneDto planeDto = new PlaneDto();
        planeDto.setId(plane.getId().toString());
        planeDto.setModel(plane.getModel());
        planeDto.setNumberOfSeats(plane.getNumberOfSeats());
        planeDto.setFullPlaneDetails(plane.getModel().concat("-").concat(plane.getNumberOfSeats().toString()));

        return planeDto;
    }

    public final static List<PlaneDto> toListDto(Iterable<Plane> planeList) {
        List<PlaneDto> listDto = new ArrayList<>();
        planeList.forEach(plane -> listDto.add(toDto(plane)));

        return listDto;
    }

    public final static Plane fromDto(PlaneDto planeDto) {
        Plane plane = new Plane();
        PlaneAdapter.fromDto(planeDto, plane);

        return plane;
    }

    public final static Plane fromDto(PlaneDto planeDto, Plane plane) {
        plane.setModel(planeDto.getModel());
        plane.setNumberOfSeats(planeDto.getNumberOfSeats());

        return plane;
    }
}
