package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Airplanes;
import com.p5.flightmanager.service.dto.AirplaneDto;

import java.util.ArrayList;
import java.util.List;

public class AirplaneAdapter {

    public final static AirplaneDto toDto(Airplanes airplanes) {
        AirplaneDto airplaneDto = new AirplaneDto();
        airplaneDto.setId(airplanes.getId().toString());
        airplaneDto.setModel(airplanes.getModel());
        airplaneDto.setNumberOfSeats(airplanes.getNumberOfSeats());
        airplaneDto.setFullPlaneDetails(airplanes.getModel().concat("-").concat(airplanes.getNumberOfSeats().toString()));

        return airplaneDto;
    }

    public final static List<AirplaneDto> toListDto(Iterable<Airplanes> planeList) {
        List<AirplaneDto> listDto = new ArrayList<>();
        planeList.forEach(airplanes -> listDto.add(toDto(airplanes)));

        return listDto;
    }

    public final static Airplanes fromDto(AirplaneDto airplaneDto) {
        Airplanes airplanes = new Airplanes();
        AirplaneAdapter.fromDto(airplaneDto, airplanes);

        return airplanes;
    }

    public final static Airplanes fromDto(AirplaneDto airplaneDto, Airplanes airplanes) {
        airplanes.setModel(airplaneDto.getModel());
        airplanes.setNumberOfSeats(airplaneDto.getNumberOfSeats());

        return airplanes;
    }
}
