package com.javaschool.trains.domain.ticket;

import com.javaschool.trains.domain.passenger.Passenger;
import com.javaschool.trains.domain.schedule.Schedule;
import com.javaschool.trains.domain.seat.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {
    int idPassenger;
    int idSchedule;
    int idSeat;
}
