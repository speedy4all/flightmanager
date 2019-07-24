package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.FlightSimpleDto;
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

    @Query("select f from Flight f where f.departureDate=:departureDate " +
            "and f.departureAirport.city=:location " +
            "and f.destinationAirport.city=:destination")
    Iterable<Flight> getBySearchParams(Date departureDate, String location, String destination);

    @Query("select f from Flight f " +
            "join f.departureAirport a " +
            "where f.departureDate=:departureDate and a.city=:departureLocation")
    Iterable<Flight> findByDateAndName(Date departureDate, String departureLocation);

    //TODO: lista de flight-uri care sa contina id-ul flight-ului, numele flight-ului, departure&destination date&city; DONE
    @Query("select new com.p5.flightmanager.service.dto.FlightSimpleDto(depAirport.iata, desAirport.iata, depAirport.name, desAirport.name, flight.departureDate, flight.destinationDate, depAirport.id, desAirport.id, flight.flightType) from Flight flight " +
            "inner join flight.departureAirport depAirport " +
            "inner join flight.destinationAirport desAirport  ")
    Iterable<FlightSimpleDto> findSimpleFlightDto();

    @Query("select f from Flight f " +
            "join f.departureAirport departure " +
            "join f.destinationAirport destination " +
            "join f.plane plane where " +
            "departure.id=:departureId and destination.id=:destinationId and f.departureDate=:departureDate")
    Iterable<Flight> getByDepartureIdAndDestinationIdAndDepartureDate(UUID departureId, UUID destinationId, Date departureDate);

    @Query("select f from Flight f")
    Iterable<Flight> getAll();
}

/*



flights.forEach(flight -> {
            if (flight.getPassengerList().size() < 10 && flight.getDurationTime()
                    < 120 && flightSimpleDtoList.size() != 10){
                flightSimpleDtoList.add(FlightAdapter.toSimpleDto(flight));
                flightsRepository.save(flight);
            }
        });

 */