package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightDtoSimple;
import com.p5.flightmanager.service.dto.FlightDtoView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface FlightsRepository extends CrudRepository<Flight, UUID> {

    @Query("select f from Flight f where lower(name) like concat('%',lower(?1),'%') order by f.departureDate")
    Iterable<Flight> filterByName(String search);

    @Query("select f from Flight f where f.departureDate=:departureDate and f.locationAirport.location=:location")
    Iterable<Flight> getBySearchparams(Date departureDate, String location);

    @Query("select f from Flight f " +
            "join f.locationAirport a " +
            "where f.departureDate=:departureDate and a.location=:departureLocation")
    Iterable<Flight> findByDateAndName(Date departureDate, String departureLocation);

    @Query("select new com.p5.flightmanager.service.dto.FlightDto(flight.name, locationAirport.location, flight.departureDate) from Flight flight " +
            "join flight.locationAirport locationAirport " +
            "where flight.departureDate=:departureDate and locationAirport.location=:departureLocation")
    Iterable<FlightDto> findByNameAndDAte(Date departureDate, String departureLocation);

    @Query("select new com.p5.flightmanager.service.dto.FlightDtoView(flight.id, flight.departureDate, flight.destinationDate, " +
            "flight.durationTime, destinationAirport.location, locationAirport.location, flight.plane.seats - flight.passengerList.size) from Flight flight " +
            "join flight.locationAirport locationAirport " +
            "join flight.destinationAirport destinationAirport " +
            "where destinationAirport.id=:destinationAirportId and locationAirport.id=:locationAirportId")
    Iterable<FlightDtoView> findByLocationIdAndDestinationIdAirport(UUID locationAirportId, UUID destinationAirportId);

    //TODO:
//    @Query("select new com.p5.flightmanager.service.dto.FlightDtoSimple(flight.name, locationAirport.location, destinationAirport.location, " +
//            "flight.durationTime, destinationAirport.location, locationAirport.location, flight.plane.seats - flight.passengerList.size) from Flight flight " +
//            "join flight.locationAirport locationAirport " +
//            "join flight.destinationAirport destinationAirport " +
//            "where locationAirport.departureDate=:departureDate and locationAirport.location=:departureLocation")
//    Iterable<FlightDtoSimple> findByNameAndDateSimple(Date departureDate, String departureLocation);
}
