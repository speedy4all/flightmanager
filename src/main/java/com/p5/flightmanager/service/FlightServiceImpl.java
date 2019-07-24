package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportRepository;
import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.*;
import com.p5.flightmanager.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private AirportService airportService;

    //    @Override
//    public List<FlightDto> getAll(String search) {
//
//        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
//    }
    @Override
    public List<FlightDtoView> getAll(String search) {

        return FlightAdapter.toListDtoView(flightsRepository.filterByName(search));
    }


    @Override
    public FlightDto createFlight(FlightDto flightDto) {


        validateFlightDto(flightDto);

        Flight flight = FlightAdapter.fromDto(flightDto);

        Optional<Airport> departureOptionalAirport = airportRepository.findById(UUID.fromString(flightDto.getDepartureLocation()));
        Optional<Airport> destinationOptionalAirport = airportRepository.findById(UUID.fromString(flightDto.getDestinationLocation()));

        if (departureOptionalAirport.isPresent() && destinationOptionalAirport.isPresent()) {
            flight.setDepartureLocation(departureOptionalAirport.get());
            flight.setDestinationLocation(destinationOptionalAirport.get());
        }

        return FlightAdapter.toDto(flightsRepository.save(flight));

    }

    private void validateFlightDto(FlightDto flightDto) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        if (flightDto.getDestinationLocation() == null) {
            apiError.getSubErrors().add(new ApiSubError("destinationLocation", "Null received"));
        }
        if (flightDto.getFlightType() == null) {
            apiError.getSubErrors().add(new ApiSubError("flightType", "Null received", String.valueOf(flightDto.getFlightType())));
        }
        if (flightDto.getDurationTime() > 180) {
            apiError.getSubErrors().add(new ApiSubError("flightType", String.valueOf(flightDto.getDurationTime()), "Should be less then 180"));
        }


        if (apiError.getSubErrors().size() > 0) {
            throw new FlightValidationException(apiError);
        }
    }

    @Override
    public FlightDto updateFlight(FlightDto flightDto) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
        if (optionalFlight.isPresent()) {

            return FlightAdapter.toDto(flightsRepository.save(FlightAdapter.fromDto(flightDto, optionalFlight.get())));
        }
        throw new NoFlightException();
    }

    @Override
    public ListResponseDto<ResponseFlightDto> searchBy(FlightSearchDto searchDto) {
        ListResponseDto<ResponseFlightDto> response = new ListResponseDto<>();

        Iterable<ResponseFlightDto> flights = flightsRepository.getByDepartureIdAndDestinationIdAndDepartureDate(UUID.fromString(searchDto.getDepartureId()), UUID.fromString(searchDto.getDestinationId()), searchDto.getDepartureDate());
        flights.forEach(response.getList()::add);
        response.setTotalCount(Long.valueOf(response.getList().size()));
        return response;

    }

    @Override
    public FlightDto getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            return FlightAdapter.toDto(flight);
        }
        throw new NoFlightException();
    }

    @Override
    public void deleteFlight(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flightsRepository.delete(flight);
        }
    }

    @Override
    public List<FlightDto> getBySearchParams(Date departureDate, String location, String destination) {
        Iterable<Flight> flights = flightsRepository.getBySearchParams(departureDate, location, destination);
        return FlightAdapter.toListDto(flights);
    }

    @Override
    public void addPassenger(String flightId, String passengerId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if (optionalFlight.isPresent()) {
            Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(passengerId));
            if (optionalFlight.get().getPassengerList().size() <= optionalFlight.get().getPlane().getSeats()) {
                if (optionalPassenger.isPresent()) {
                    Flight flight = optionalFlight.get();
                    flight.getPassengerList().add(optionalPassenger.get());
                    flightsRepository.save(flight);
                }
            }
        }
    }

    @Override
    public void removePassenger(String uniqueIdentifier, String flightId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()){
            Optional<Passenger> optionalPassenger = passengerRepository.getByUniqueIdentifier(uniqueIdentifier);
            if(optionalPassenger.isPresent()){
               if(optionalFlight.get().getPassengerList().contains(optionalPassenger.get())){
                   optionalFlight.get().getPassengerList().remove(optionalPassenger.get());
                   flightsRepository.save(optionalFlight.get());
               }
            }
        }
    }

    @Override
    public void addPassengerDto(FlightUpdateDto flightUpdateDto) {
        validateUpdateFlight(flightUpdateDto);

        Flight flight = getFlightById(UUID.fromString(flightUpdateDto.getFlightId()));

        //validateAvailableSeat(flight);
        Passenger passenger = passengerService.getOrCreate(flightUpdateDto.getUniqueIdentifier(), flightUpdateDto.getPassengerName());
        boolean exists = flight.getPassengerList().stream().map(Passenger::getIdentifyNumber).anyMatch(s -> s.equals(flightUpdateDto.getUniqueIdentifier()));

        if(!exists) {
            flight.getPassengerList().add(passenger);
            flightsRepository.save(flight);
        } else {
            //throw new PassengerExistException(flightUpdateDto.getUniqueIdentifier());
            throw new PassengerExistException(flightUpdateDto.getUniqueIdentifier());
        }
}

    @Override
    public Flight getFlightById(UUID flightId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(flightId);
        if (optionalFlight.isPresent()) {
            return optionalFlight.get();
        }
        throw new NoFlightException();
    }

    /////
    @Override
    public List<FlightDtoView> getAllOffers() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        Date endDate = cal.getTime(); // get back a Date objec


        Pageable pageable = PageRequest.of(0, 10);
        List<Flight> list = flightsRepository.getAllOffers(endDate, pageable);
        List<FlightDtoView> offers = FlightAdapter.toListDtoView(list);

        return offers;
    }

    private void validateUpdateFlight(FlightUpdateDto flightUpdateDto) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightUpdateDto.getFlightId()));
        if(!optionalFlight.isPresent()) {
            apiError.getSubErrors().add(new ApiSubError("flight", "flight not found"));
        }
//        Optional<Passenger> passenger = passengerRepository.getByUniqueIdentifier(flightUpdateDto.getUniqueIdentifier());
//        if(passenger.isPresent()) {
//            apiError.getSubErrors().add(new ApiSubError("passenger", "passenger already found"));
//        }
        if(flightUpdateDto.getFlightId() == null)
        {
            apiError.getSubErrors().add(new ApiSubError("id", "id is null"));
        }
        if(apiError.getSubErrors().size() > 0) {
            throw new NoPassengerException();
        }
    }

    @Override
    public void addPassengerToFlight(String flightId, String passengerId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if (optionalFlight.isPresent()) {
            Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(passengerId));
            if (optionalFlight.get().getPassengerList().size() <= optionalFlight.get().getPlane().getSeats()) {
                if (optionalPassenger.isPresent()) {
                    Flight flight = optionalFlight.get();
                    flight.getPassengerList().add(optionalPassenger.get());
                    flightsRepository.save(flight);
                }
            }
        }
    }

    @Override
    public Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(SearchParamDto searchParamDto) {
        return flightsRepository.findByNameAndDAteSimple(searchParamDto.getDepartureDate(), searchParamDto.getLocation());
    }

//    @Override
//    public Iterable<FlightDtoParamSearch> getByDepIdAndDestIdAndDepDate(SearchParamDtoFlight searchParamDtoFlight) {
//        return flightsRepository.findByIdAndDate(searchParamDtoFlight.getDepartureDate(), searchParamDtoFlight.getDepartureId(), searchParamDtoFlight.getDestinationId());
//    }
}
