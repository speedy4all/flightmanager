package com.p5.flightmanager.repository.models;

import com.p5.flightmanager.service.dto.FlightType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "T_FLIGHT")
public class Flight extends BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column
    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Airport.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport_id", foreignKey = @ForeignKey(name = "fk_flight_departure_airport"))
    private Airport departureAirport;

    //TODO: destination-location ManyToOne; DONE
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Airport.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_airport_id", foreignKey = @ForeignKey(name = "fk_flight_destination_airport"))
    private Airport destinationAirport;

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

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Passenger.class)
    @JoinTable(name = "t_flight_passenger",
            joinColumns = {@JoinColumn(name = "flight_id", nullable = false, foreignKey = @ForeignKey(name = "fk_flight_passenger"))},
            inverseJoinColumns = {@JoinColumn(name = "passenger_id", nullable = false, foreignKey = @ForeignKey(name = "fk_passenger_flight"))},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"flight_id", "passenger_id"}, name = "uk_flight_passenger")},
            indexes = {@Index(columnList = "passenger_id", name = "ix_flight_passenger")})
    List<Passenger> passengerList = new ArrayList<>();

    //TODO: legatura plane-flight OneToOne; DONE
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Plane.class)
    @JoinColumn(name = "plane_id", foreignKey = @ForeignKey(name = "fk_flight_plane"))
    private Plane plane;

    public Flight() {
        //default constructor
    }

    public Flight(String name, Airport departureAirport, Airport destinationAirport, Double durationTime, Date departureDate, Date destinationDate) {
        this.name = name;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.durationTime = durationTime;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
    }

    public Flight(Flight source) {
        super(source);
        this.name = source.name;
        this.departureAirport = source.departureAirport;
        this.destinationAirport = source.destinationAirport;
        this.durationTime = source.durationTime;
        this.departureDate = source.departureDate;
        this.destinationDate = source.destinationDate;
    }

    public Plane getPlane() { return plane; }

    public void setPlane(Plane plane) { this.plane = plane; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getDepartureAirport() { return departureAirport; }

    public void setDepartureAirport(Airport departureAirport) { this.departureAirport = departureAirport; }

    public Airport getDestinationAirport() { return destinationAirport; }

    public void setDestinationAirport(Airport destinationAirport) { this.destinationAirport = destinationAirport; }

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

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public List<Passenger> getPassengerList() { return passengerList; }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
