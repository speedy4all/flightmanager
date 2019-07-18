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

    @Column(name = "name")
    @Type(type = "string")
    private String name;

    @Column(name = "departure_location")
    @Type(type = "string")
    private String departureLocation;

    @Column(name = "destination_location")
    @Type(type = "string")
    private String destinationLocation;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "flight_type")
    private FlightType flightType;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Passenger.class)
            @JoinTable(name = "T_FLIGHT_PASSENGER",
            joinColumns = { @JoinColumn(name = "flight_id", nullable = false, foreignKey = @ForeignKey(name = "fk_flight_passenger"))},
                    inverseJoinColumns = { @JoinColumn(name = "passenger_id", nullable = false, foreignKey = @ForeignKey(name = "fk_passenger_flight"))},
            uniqueConstraints = { @UniqueConstraint(columnNames = {"flight_id", "passenger_id"}, name = "uk_flight_passenger")},
            indexes = { @Index(columnList = "passenger_id", name = "ix_flight_passenger")})
    private List<Passenger> passengerList = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Plane.class)
//    @JoinTable()
//    private Plane plane;

    public Flight() {
        //default constructor
    }

    public Flight(String name, String departureLocation, String destinationLocation, Double durationTime, Date departureDate, Date destinationDate) {
        this.name = name;
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
        this.durationTime = durationTime;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
    }

    public Flight(Flight source) {
        super(source);
        this.name = source.name;
        this.departureLocation = source.departureLocation;
        this.destinationLocation = source.destinationLocation;
        this.durationTime = source.durationTime;
        this.departureDate = source.departureDate;
        this.destinationDate = source.destinationDate;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
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

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
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
}
