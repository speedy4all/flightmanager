package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.CancelReservationDto;
import com.p5.flightmanager.service.dto.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightDtoSimple;
import com.p5.flightmanager.service.dto.FlightSearchDto;
import com.p5.flightmanager.service.dto.FlightUpdateDto;
import com.p5.flightmanager.service.dto.ListResponseDto;
import com.p5.flightmanager.service.dto.ResponseFlightDto;
import com.p5.flightmanager.service.dto.SearchParamDto;
import com.p5.flightmanager.service.exceptions.ApiError;
import com.p5.flightmanager.service.exceptions.ApiSubError;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.FlightValidationException;
import com.p5.flightmanager.service.exceptions.NoFlightException;
import com.p5.flightmanager.service.exceptions.NoPassengerException;
import com.p5.flightmanager.service.exceptions.PassengerExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private AirportService airportService;

    @Autowired
    private PassengerService passengerService;


    @Override
    public ListResponseDto<ResponseFlightDto> getAll(String search) {

        return FlightAdapter.toResponseListDto(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {

        validateFlightDto(flightDto);

        return FlightAdapter.toDto(flightsRepository.save(FlightAdapter.fromDto(flightDto)));

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

    private void validateFlightDto(FlightDto flightDto) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        if (flightDto.getDepartureLocation() == null) {
            apiError.getSubErrors().add(new ApiSubError("departureLocation", "Can not be null"));
        }

        if (flightDto.getDestinationLocation() == null) {
            apiError.getSubErrors().add(new ApiSubError("destinationLocation", "Can not be null"));

        }

        if (flightDto.getDurationTime() > 180) {
            apiError.getSubErrors().add(new ApiSubError("durationTime", "Value must be under 180", String.valueOf(flightDto.getDurationTime())));

        }

        if (apiError.getSubErrors().size() > 0) {
            throw new FlightValidationException(apiError);
        }

    }

    @Override
    public List<FlightDto> getBySearchParams(Date departureDate, String location, String destination) {
        Iterable<Flight> flights = flightsRepository.getBySearchParams(departureDate, location, destination);
        return FlightAdapter.toListDto(flights);
    }

    @Override
    public void addPassengerToFlight(String flightId, String passengerId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if (optionalFlight.isPresent()) {
            Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(passengerId));
            if (optionalPassenger.isPresent()) {
                Flight flight = optionalFlight.get();
                flight.getPassengerList().add(optionalPassenger.get());
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(SearchParamDto searchParamDto) {
        return flightsRepository.findByNameAndDAteSimple(searchParamDto.getDepartureDate(), searchParamDto.getLocation());
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
    public Flight getFlightById(UUID flightId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(flightId);
        if (optionalFlight.isPresent()) {
            return optionalFlight.get();
        }
        throw new NoFlightException();

    }

    @Override
    public ListResponseDto<ResponseFlightDto> findAll() {
        Iterable<Flight> all = flightsRepository.findAll();
        ListResponseDto<ResponseFlightDto> dtoListResponseDto = FlightAdapter.toResponseListDto(all);
        return dtoListResponseDto;
    }

    @Override
    public CancelReservationDto cancelReservation(CancelReservationDto cancelReservationDto) {
        Optional<Flight> flightOptional = flightsRepository.findById(UUID.fromString(cancelReservationDto.getFlightId()));
        if(flightOptional.isPresent()) {
            Flight flight = flightOptional.get();
            Optional<Passenger> optionalPassenger = flight.getPassengerList().stream().filter(p -> p.getIdentifyNumber().equals(cancelReservationDto.getIdentifier())).findFirst();
            if(optionalPassenger.isPresent()) {
                flight.getPassengerList().remove(optionalPassenger.get());
                flightsRepository.save(flight);
                return cancelReservationDto;
            } else {
                throw new NoPassengerException();
            }
        } else {
            throw new NoFlightException();
        }
    }

    @Override
    public FlightDto addPassenger(FlightUpdateDto flightUpdateDto) {
        validateUpdateFlightDto(flightUpdateDto);

        Flight flight = getFlightById(UUID.fromString(flightUpdateDto.getFlightId()));

        validateForAvailableSeat(flight);
        Passenger passenger = passengerService.getOrCreate(flightUpdateDto.getUniqueIdentifier(), flightUpdateDto.getPassengerName());

        boolean exists = flight.getPassengerList().stream().map(Passenger::getIdentifyNumber).anyMatch(s -> s.equals(flightUpdateDto.getUniqueIdentifier()));
        if(!exists) {
            flight.getPassengerList().add(passenger);
            return FlightAdapter.toDto(flightsRepository.save(flight));
        } else {
            throw new PassengerExistException(flightUpdateDto.getUniqueIdentifier());
        }

    }

    private void validateForAvailableSeat(Flight flight) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);


        if (apiError.getSubErrors().size() > 0) {
            throw new FlightValidationException(apiError);
        }
    }

    private void validateUpdateFlightDto(FlightUpdateDto flightUpdateDto) {
        //todo implement validation
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        try {
            UUID uuid = UUID.fromString(flightUpdateDto.getFlightId());
            if (uuid == null) {
                apiError.getSubErrors().add(new ApiSubError("flightId", "bad format"));
            }
        } catch (Exception ex) {
            apiError.getSubErrors().add(new ApiSubError("flightId", "bad format from catch"));
        } finally {
            if (apiError.getSubErrors().size() > 0) {
                throw new FlightValidationException(apiError);
            }
        }


    }
}
