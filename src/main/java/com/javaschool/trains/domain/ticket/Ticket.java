package com.javaschool.trains.domain.ticket;

import com.javaschool.trains.domain.passenger.Passenger;
import com.javaschool.trains.domain.schedule.Schedule;
import com.javaschool.trains.domain.seat.Seat;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTicket", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seat", nullable = false)
    private Seat seat;

    @Column(name = "isDelete")
    private Boolean isDelete;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "schedule", nullable = false)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "passengerID", nullable = false)
    private Passenger passenger;


}