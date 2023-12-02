package com.javaschool.trains.domain.seat;

import com.javaschool.trains.domain.train.Train;
import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseat", nullable = false)
    private Integer id;

    @Column(name = "is_seat_free", nullable = false)
    private Byte isSeatFree;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_number", nullable = false)
    private Train trainNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getIsSeatFree() {
        return isSeatFree;
    }

    public void setIsSeatFree(Byte isSeatFree) {
        this.isSeatFree = isSeatFree;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Train getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Train trainNumber) {
        this.trainNumber = trainNumber;
    }

}