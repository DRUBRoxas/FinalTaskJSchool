package com.javaschool.Trains.Entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSchedule", nullable = false)
    private Integer id;

    @Column(name = "departureTime", nullable = false)
    private LocalTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departureStation", nullable = false)
    private Station departureStation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "originStation", nullable = false)
    private Station originStation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_Number", nullable = false)
    private Train trainNumber;

    @Column(name = "isDelete")
    private Byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getOriginStation() {
        return originStation;
    }

    public void setOriginStation(Station originStation) {
        this.originStation = originStation;
    }

    public Train getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Train trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

}