package com.p5.flightmanager.service.dto;



import com.p5.flightmanager.repository.models.Plane;

import com.p5.flightmanager.service.dto.PlaneDto;



import java.util.ArrayList;

import java.util.List;



public class PlaneAdapter {



    public final static PlaneDto toDto (Plane plane) {



        PlaneDto planeDto = new PlaneDto();



        planeDto.setId(plane.getId().toString());

        planeDto.setCode(plane.getCode());

        planeDto.setModel(plane.getModel());

        planeDto.setCompanyName(plane.getCompanyName());

        planeDto.setSeats(plane.getSeats());



        return planeDto;

    }



    public final static Plane fromDto(PlaneDto planeDto) {



        Plane plane = new Plane();

        fromDto(planeDto, plane);

        return plane;

    }



    public final static Plane fromDto(PlaneDto planeDto, Plane plane) {



        plane.setCode(planeDto.getCode());

        plane.setCompanyName(planeDto.getCompanyName());

        plane.setModel(planeDto.getModel());

        plane.setSeats(planeDto.getSeats());



        return plane;

    }



    public final static List<PlaneDto> toListDto(Iterable<Plane> planes) {

        List<PlaneDto> planeDto = new ArrayList<>();

        planes.forEach(plane -> planeDto.add(toDto(plane)));



        return planeDto;

    }



}