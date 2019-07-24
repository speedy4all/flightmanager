package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.FlightDtoSimple;
import com.p5.flightmanager.service.dto.ResponseFlightDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface FlightsRepository extends CrudRepository<Flight, UUID> {

    @Query("select f from Flight f where lower(name) like concat('%',lower(?1),'%')")
    Iterable<Flight> filterByName(String search);

    @Query("select f from Flight f where f.departureDate=:departureDate and f.locationAirport.location=:location")
    Iterable<Flight> getBySearchparams(Date departureDate, String location);

    @Query("select f from Flight f " +
            "join f.locationAirport a " +
            "where f.departureDate=:departureDate and a.location=:departureLocation")
    Iterable<Flight> findByDateAndName(Date departureDate, String departureLocation);

    @Query("select new com.p5.flightmanager.service.dto.FlightDtoSimple(flight.name, flight.locationAirport.location, flight.destinationAirport.location) from Flight flight " +
            "join flight.locationAirport locationAirport " +
            "where flight.departureDate=:departureDate and locationAirport.location=:departureLocation")
    Iterable<FlightDtoSimple> findByNameAndDAte(Date departureDate, String departureLocation);

    @Query("select distinct new com.p5.flightmanager.service.dto.ResponseFlightDto(flight.id, flight.locationAirport.name, flight.locationAirport.code, flight.destinationAirport.name, flight.destinationAirport.code, flight.departureDate, flight.destinationDate, flight.plane.model, flight.durationTime, flight.plane.seats - flight.passengerList.size) from Flight flight " +
            "join flight.locationAirport locationAirport " +
            "join flight.destinationAirport destinationAirport " +
            "join flight.passengerList passengers " +
            "join flight.plane plane " +
            "where destinationAirport.id=:destinationAirportId and locationAirport.id=:locationAirportId and departureDate=:departureDate")
    Iterable<ResponseFlightDto> getByLocationIdAndDestinationIdAndDepartureDate(UUID locationAirportId, UUID destinationAirportId, Date departureDate);

    @Query("select flight from Flight flight where flight.passengerList.size < 10 and departure_date > now() and departure_date < :endDate")
    List<Flight> getAllOffers(Date endDate, Pageable pageable);

    @Query("select flight from Flight flight " +
            "join flight.passengerList p " +
            "where p.id = :id")
    List<Flight> getAllMyFlights(UUID id);

}
