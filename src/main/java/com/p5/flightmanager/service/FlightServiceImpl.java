package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportsRepository;
import com.p5.flightmanager.repository.PassengersRepository;
import com.p5.flightmanager.repository.PlanesRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.repository.models.Plane;
import com.p5.flightmanager.service.api.FlightService;
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
//aici trebuie sa avem doar flightRepository, pentru celelalte folosim serviciile lor !
    @Autowired
    private FlightsRepository flightsRepository;

    //la flightcontroller vom folosi metoda de updateFLight si va primi un obiect cu flightId, uniqueId, passengerName. (FlightUpdateDto)
    //cream o met in serv care il valideaza
    //
    @Autowired
    private PassengersRepository passengerRepository;
    //get flights/get offers ret iter/lista flight de dto mare, fara parametru,
    //in service implementam un alg care sa aduca pe baza criteriilor noastre (de ex. acel flight e la oferta daca nu are mai mult de
    //10 pasageri si dataDeparture nu e mai mult de 3 zile)
    //nu mai mult de 10 flight-uri sa returnam

    @Autowired
    private PlanesRepository planeRepository;

    @Autowired
    private PlaneServiceImpl planeService;

    @Autowired
    private AirportsRepository airportsRepository;

    @Autowired
    private PassengerServiceImpl passengerService;


    @Override
    public FlightDto createFlight(PostFlightDto postFlightDto) {

        Optional<Plane> optionalPlane = planeRepository.findById(UUID.fromString(postFlightDto.getPlaneId()));
        validateFlightDto(postFlightDto);

        if(!optionalPlane.isPresent()) {
            throw new NoAirportException(); //TODO NoPlaneException
        }
        Optional<Airport> optionalLocation = airportsRepository.findById(UUID.fromString(postFlightDto.getLocationAirportId()));
        if(!optionalLocation.isPresent()) {
            throw  new NoAirportException();
        }
        Optional<Airport> optionalDestination = airportsRepository.findById(UUID.fromString(postFlightDto.getDestinationAirportId()));
        if(!optionalDestination.isPresent()) {
            throw new NoAirportException();
        }
        return FlightAdapter.toDto(flightsRepository.save(FlightAdapter.fromPostDto(postFlightDto, optionalPlane.get(), optionalLocation.get(), optionalDestination.get())));
    }

    public List<FlightDto> getAll(String search) {

        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
    }

    @Override
    public Iterable<FlightDtoSimple> getAllFlights() {
        return FlightAdapter.toListSimpleDto(flightsRepository.findAll());
    }

    @Override
    public Flight getFlightById(UUID id) {
        Optional<Flight> flight = flightsRepository.findById(id);
        if(flight.isPresent()) {
            return flight.get();
        }
        throw new NoFlightException();
    }

    @Override
    public List<FlightDto> getBySearchParams(Date departureDate, String location) {
        Iterable<Flight> flights = flightsRepository.getBySearchparams(departureDate, location);
        return FlightAdapter.toListDto(flights);
    }

    @Override
    public Iterable<FlightDto> getByDepDateAndDestDateAndLocation(SearchParamFlightDto searchParamDto) {
        return flightsRepository.findByNameAndDAte(searchParamDto.getDepartureDate(), searchParamDto.getLocation());
    }

    @Override
    public Iterable<FlightDtoView> getByLocationIdAndDestinationIdAirportAndDate(SearchParamsFlightDtoView searchParamDto) {
        return flightsRepository.findByLocationIdAndDestinationIdAirportAndDate(UUID.fromString(searchParamDto.getLocationAirportId())
                , UUID.fromString(searchParamDto.getDestinationAirportId()), searchParamDto.getDepartureDate());
    }

    //todo amount -> default
    @Override
    public List<FlightDtoSimple> getOffers() {
        Calendar currentDate = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,7);
        //makes a list with maximum 10 elemnts
        Pageable pageable = PageRequest.of(0,10);
        List<Flight> offersFlights = flightsRepository.getAllOffers(cal.getTime(), pageable);
        List<FlightDtoSimple> offers = FlightAdapter.toListSimpleDto(offersFlights);
        return offers;
    }

    //todo getAllMyFlight to return FlightDtoSimple
    @Override
    public List<FlightDtoSimple> getAllMyFlights(String id) {
        List<Flight> flights = flightsRepository.getAllMyFlights(UUID.fromString(id));
        List<FlightDtoSimple> flightDtoSimples = FlightAdapter.toListSimpleDto(flights);
        return flightDtoSimples;
    }

    @Override
    public FlightDto getById(String id) {

        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            return FlightAdapter.toDto(flight);
        }
        throw new NoFlightException();
    }

    @Override
    public ListDto<FlightDtoView> searchBy(SearchParamsFlightDtoView search) {
//        List<FlightDtoView> result = FlightAdapter.toListDtoView(flights);
//        return result;
        ListDto<FlightDtoView> response = new ListDto<>();
        Iterable<FlightDtoView> flights = flightsRepository.findByLocationIdAndDestinationIdAirportAndDate(UUID.fromString(search.getLocationAirportId()), UUID.fromString(search.getDestinationAirportId()), search.getDepartureDate());
        flights.forEach(response.getObjects()::add);
        response.setCount(Long.valueOf(response.getObjects().size()));
        return response;
    }

    @Override
    public FlightDto updateFlight(FlightDto flightDto) {

         Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
         if(optionalFlight.isPresent()){
             return FlightAdapter.toDto( flightsRepository.save(FlightAdapter.fromDto(flightDto,optionalFlight.get())));
         }

        throw new NoFlightException();
    }

    //eu
    @Override
    public void addPassengerToFlight(String flightId, String passengerId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()) {
            //plane vine null (cred)
            //if(optionalFlight.get().getPassengerList().size() <= optionalFlight.get().getPlane().getSeats())
            // {
            Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(passengerId));
            if(optionalPassenger.isPresent()) {
                Flight flight = optionalFlight.get();
                optionalFlight.get().getPassengerList().add(optionalPassenger.get());
                flightsRepository.save(flight);
            }
            // }
        }
    }

    @Override
    public void addPlaneToFlight(String flightId, String planeId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()) {
            Optional<Plane> optionalPlane = planeRepository.findById(UUID.fromString(planeId));
            if(optionalPlane.isPresent()) {
                Flight flight = optionalFlight.get();
                Plane plane = optionalPlane.get();
                flight.setPlane(plane);
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public void addDestinationAirport(String flightId, String destinationAirportId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()) {
            Optional<Airport> optionalAirport = airportsRepository.findById(UUID.fromString(destinationAirportId));
            if(optionalAirport.isPresent()) {
                Flight flight = optionalFlight.get();
                Airport airport = optionalAirport.get();
                flight.setDestinationAirport(airport);
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public void addLocationAirport(String flightId, String locationnAirportId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()) {
            Optional<Airport> optionalAirport = airportsRepository.findById(UUID.fromString(locationnAirportId));
            if(optionalAirport.isPresent()) {
                Flight flight = optionalFlight.get();
                Airport airport = optionalAirport.get();
                flight.setLocationAirport(airport);
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public void addPassenger(FlightUpdateDto flightDto) {
        Flight flight = getFlightById(UUID.fromString(flightDto.getFlightId()));
        validateUpdateFlightDto(flightDto);
        Passenger passenger = passengerService.getOrCreate(flightDto.getUniqueIdentifier(),flightDto.getName());
        boolean anyMatch = flight.getPassengerList().stream().map(Passenger::getpersonalID).anyMatch(s -> s.equals(flightDto.getUniqueIdentifier()));
        //stream e o copie/secventa a obiectelor respectve pe care poti itera
        //suporta ceva
        //face singur iteratie
        //putem genera stream simplu sau paralel stream
        if(!anyMatch) {
            flight.getPassengerList().add(passenger);
            flightsRepository.save(flight);
        } else {
            throw new PassengerExistException(flightDto.getUniqueIdentifier());
        }
    }

    @Override
    public void deleteFlight(String flightDtoID) {

        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDtoID));
        if(optionalFlight.isPresent()){
            flightsRepository.delete(optionalFlight.get());
            return;
        }

        throw new NoFlightException();
    }

    @Override
    public void deletePassenger(String flightId, String personalId) {
        Optional<Flight> flight = flightsRepository.findById(UUID.fromString(flightId));
        Optional<Passenger> passenger = passengerRepository.findById(UUID.fromString(personalId));
        if(flight.isPresent()) {
            if(passenger.isPresent()) {
                if(flight.get().getPassengerList().contains(passenger.get())) {
                    flight.get().getPassengerList().remove(passenger.get());
                    flightsRepository.save(flight.get());
                }
            }
        }
    }

    private void validateUpdateFlightDto(FlightUpdateDto flightDto) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);

        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getFlightId()));
        if(!optionalFlight.isPresent()) {
            apiError.getSubErrors().add(new ApiSubError("flight", "flight not found"));
        }
//        Optional<Passenger> passenger = passengerRepository.getByUniqueIdentifier(flightDto.getUniqueIdentifier());
//        if(!passenger.isPresent()) {
//            apiError.getSubErrors().add(new ApiSubError("passenger", "passenger already found"));
//        }
        if(flightDto.getFlightId() == null)
        {
            apiError.getSubErrors().add(new ApiSubError("id", "id is null"));
        }
        if(apiError.getSubErrors().size() > 0) {
            throw new PassengerException();
        }
    }

    private void validateFlightDto(PostFlightDto flightDto) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        if(flightDto.getDepartureDate() == null) {
            apiError.getSubErrors().add(new ApiSubError("departureDate", "Can not be null"));
        }

        if(flightDto.getDestinationAirportId() == null) {
            apiError.getSubErrors().add(new ApiSubError("destinationAirportId", "Can not be null"));
        }

        if(flightDto.getDurationTime() > 180) {
            apiError.getSubErrors().add(new ApiSubError("durationTime", "Value must be under 180", String.valueOf(flightDto.getDurationTime())));
            //cu value of nu crapa daca flightDto.getDurationTime e null
            //to string, crapa
        }

        if(apiError.getSubErrors().size() > 0) {
            throw new FlightValidationException(apiError);
        }
    }

}
