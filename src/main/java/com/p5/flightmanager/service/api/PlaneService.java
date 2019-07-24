
package com.p5.flightmanager.service.api;



import com.p5.flightmanager.service.dto.PlaneDto;



import java.util.List;



public interface PlaneService {



    List<PlaneDto> getAll(String search);



    PlaneDto createPlane(PlaneDto passengerDto);



    PlaneDto getById(String id);



    PlaneDto updatePlane(PlaneDto passengerDto);



    void deletePlane(String passengerDtoID);

}