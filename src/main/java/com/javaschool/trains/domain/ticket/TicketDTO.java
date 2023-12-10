package com.javaschool.trains.domain.ticket;

import com.javaschool.trains.domain.passenger.Passenger;
import com.javaschool.trains.domain.schedule.Schedule;
import com.javaschool.trains.domain.seat.Seat;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    int id;
    Passenger passenger;
    Schedule schedule;
    Seat seat;
}
