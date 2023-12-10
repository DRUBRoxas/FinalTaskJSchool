package com.javaschool.trains.domain.ticket;

import com.javaschool.trains.domain.passenger.Passenger;
import com.javaschool.trains.domain.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    Iterable<Ticket> findAllByPassenger(Passenger passenger);

    Iterable<Ticket> findAllBySchedule(Schedule schedule);

    Iterable<Object> findAllByPassengerAndSchedule(Passenger passenger, Schedule schedule);
}
