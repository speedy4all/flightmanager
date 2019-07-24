package com.p5.flightmanager.repository.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.p5.flightmanager.service.dto.FlightType;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "T_FLIGHT")
public class Flight extends BaseModel implements Serializable {
//pe flight adaugam un plane (mai multe flighturi la un plane)
//aeroport cu flight many to many
//metoda prin care asignam unui aeroport un flight
//pe aeroport o lsta de flight
//pe flight un aeroport destination, unu location
    public static final long serialVersionUID = 1L;
    //-----un dto care are o lista de ce returnam noi si un count(listDto cu un private list de T
    /*
    toate flighturile care au data de plecare o anumita data si locatia, o locatie -
    sa putem sa setam departure si destination location (airport) -
    endpoint in airport care sa returneze o lista de dto-uri care sa contina din aeroport nume, city, id.
    o lista de flighturi care sa contina id flight, departure date, destination date, duration time,
     < departure location, destination location (city de pe airport)> dupa departureairport, destinationairport id cu searchParams class
    atasare plane de flight -
    AVAILABLE SEATS CALCULATA plane.capacity - count(passengers)
    */
    @Column()
    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "duration_time")
    @Type(type = "double")
    private Double durationTime;

    @Column(name = "departure_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @Column(name = "destination_date")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date destinationDate;

    //daca punema pasagerii la plane, daca planeul are un alt zbor automat se vor lua si pasagerii (nu e corect)
    //daca plane-ul se strica si trebuie schimbat, trebuie sa am grija sa schimb si pasagerii
    //primul many e clasa in care suntem
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Passenger.class)
    //lazy = aduce datale doar in momentul in care apelam metoda de get
    @JoinTable(name = "T_FLIGHT_PASSENGER", //numele tabelei de legatura
            joinColumns = {@JoinColumn(name = "flight_id", nullable = false, foreignKey = @ForeignKey(name = "fk_flight_passenger"))},
            inverseJoinColumns = {@JoinColumn(name = "passenger_id", nullable = false, foreignKey = @ForeignKey(name = "fk_passenger_flight"))},
            uniqueConstraints = { @UniqueConstraint(columnNames = {"flight_id", "passenger_id"}, name = "uk_flight_passenger")},
            indexes = { @Index(columnList = "passenger_id", name = "ix_flight_passenger")})
    List<Passenger> passengerList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Plane.class)
    @JoinColumn(name = "plane_id")
    Plane plane;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Airport.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_airport_id", foreignKey = @ForeignKey(name = "fk_flight_destination"))
    Airport destinationAirport;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Airport.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_airport_id", foreignKey = @ForeignKey(name = "fk_flight_location"))
    Airport locationAirport;

    public Flight() {
        //default constructor
    }

    public Flight(String name, Double durationTime, Date departureDate, Date destinationDate, FlightType flightType) {
        this.name = name;
        this.durationTime = durationTime;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
        this.flightType = flightType;
    }

    public Flight(Flight source) {
        super(source);
        this.name = source.name;
        this.durationTime = source.durationTime;
        this.departureDate = source.departureDate;
        this.destinationDate = source.destinationDate;
        this.flightType = source.flightType;
    }


    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }


    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Double durationTime) {
        this.durationTime = durationTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Airport getLocationAirport() {
        return locationAirport;
    }

    public void setLocationAirport(Airport locationAirport) {
        this.locationAirport = locationAirport;
    }
}
//si locurile libere