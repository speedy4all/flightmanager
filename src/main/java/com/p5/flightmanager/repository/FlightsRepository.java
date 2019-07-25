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

    Iterable<Flight> getAllByNameIsContaining(String name);

    @Query("select f from Flight f where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Flight> filterByName(String search);

    @Query("select f from Flight f where f.departureDate=:departureDate and f.departureLocation=:location and f.destinationLocation=:destination")
    Iterable<Flight> getBySearchParams(Date departureDate, String location, String destination);


    @Query("select f from Flight f " +
            "join f.departureLocation a " +
            "where f.departureDate=:departureDate and a.city=:departureLocation")
    Iterable<Flight> findByDateAndName(Date departureDate, String departureLocation);

    @Query("select f from Flight f where f.passengerList.size < 10 and f.departureDate > now() and f.departureDate < :endDate")
    List<Flight> getAllOffers(Date endDate, Pageable pageable);

    @Query("select new com.p5.flightmanager.service.dto.FlightDtoSimple(flight.name, departureAirport.city, destinationLocation.city) from Flight flight " +
            "join flight.departureLocation departureAirport " +
            "join flight.destinationLocation destinationLocation " +
            "where flight.departureDate=:departureDate and departureAirport.city=:departureLocation")
    Iterable<FlightDtoSimple> findByNameAndDAteSimple(Date departureDate, String departureLocation);

    @Query("select distinct new com.p5.flightmanager.service.dto.ResponseFlightDto(f.id, departure.name, departure.iata, destination.name, destination.iata, f.departureDate, f.destinationDate, plane.model, f.durationTime, plane.seats - f.passengerList.size) from Flight f " +
            "join f.departureLocation departure " +
            "join f.destinationLocation destination " +
            "join f.passengerList passengers " +
            "join f.plane plane " +
            "where departure.id=:departureId and destination.id=:destinationId and f.departureDate=:departureDate order by f.departureDate desc")
    Iterable<ResponseFlightDto> getByDepartureIdAndDestinationIdAndDepartureDate(UUID departureId, UUID destinationId, Date departureDate);

//    @Query("select new com.p5.flightmanager.service.dto.FlightDtoParamSearch(flight.name, departureAirport.id, destinationAirport.id) from Flight flight " +
//            "join flight.departureLocation departureAirport " +
//            "join flight.destinationLocation destinationAirport " +
//            "where flight.departureDate=:departureDate and departureAirport.city=:departureLocation")
//    Iterable<FlightDtoParamSearch> findByIdAndDate(Date departureDate, String departureId, String destinationId);
}