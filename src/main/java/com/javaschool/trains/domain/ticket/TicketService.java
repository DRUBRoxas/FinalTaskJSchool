package com.javaschool.trains.domain.ticket;

import com.javaschool.trains.domain.passenger.Passenger;
import com.javaschool.trains.domain.passenger.PassengerRepository;
import com.javaschool.trains.domain.schedule.Schedule;
import com.javaschool.trains.domain.schedule.ScheduleRepository;
import com.javaschool.trains.domain.seat.Seat;
import com.javaschool.trains.domain.seat.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
@RequiredArgsConstructor
public class TicketService {
    @Autowired
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final ScheduleRepository scheduleRepository;
    private final SeatRepository seatRepository;


    public TicketResponse create(TicketRequest ticketRequest){
        Optional<Passenger> passenger = passengerRepository.findById(ticketRequest.getIdPassenger());
        Optional<Schedule> schedule = scheduleRepository.findById(ticketRequest.getIdSchedule());
        Optional<Seat> seat = seatRepository.findById(ticketRequest.getIdSeat());
        LocalTime time = schedule.get().getDepartureTime();
        LocalTime timeMinus10= time.minus(10, MINUTES);
        long minutos = MINUTES.between(timeMinus10, LocalTime.now());
        if(MINUTES.between(timeMinus10, LocalTime.now())<10){
            return new TicketResponse("Ticket wasn't created because departure time is in less than 10 minutes");
        }
        if (passenger.isEmpty() || schedule.isEmpty() || seat.isEmpty()) {
            return new TicketResponse("Ticket wasn't created because passenger or schedule or seat is empty");
        }
        if (ticketRepository.findAllByPassengerAndSchedule(passenger.get(),schedule.get()).spliterator().getExactSizeIfKnown() > 0) {
            return new TicketResponse("Ticket wasn't created because passenger already has ticket to this travel");
        }

        Iterable<Seat> seatIterable = seatRepository.findAllByTrainNumber(seat.get().getTrainNumber());
        long totalSeats=seatIterable.spliterator().getExactSizeIfKnown();

        if(ticketRepository.findAllBySchedule(schedule.get()).spliterator().getExactSizeIfKnown()>=totalSeats){
            return new TicketResponse("Ticket wasn't created because all seats are occupied");
        }
        Ticket ticket = Ticket.builder()
                .passenger(passenger.get())
                .schedule(schedule.get())
                .seat(seat.get())
                .build();
        ticketRepository.save(ticket);
        return new TicketResponse("Ticket was created");
    }

    public List<TicketDTO> findAll() {
        Iterable <Ticket> ticket = ticketRepository.findAll();
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (Ticket ticket1 : ticket) {
            TicketDTO ticketDTO = TicketDTO.builder()
                    .id(ticket1.getId())
                    .passenger(ticket1.getPassenger())
                    .schedule(ticket1.getSchedule())
                    .seat(ticket1.getSeat())
                    .build();
            ticketDTOList.add(ticketDTO);
        }
        return ticketDTOList;
    }

    public TicketDTO findTicketById(int id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            return TicketDTO.builder()
                    .id(ticket.get().getId())
                    .passenger(ticket.get().getPassenger())
                    .schedule(ticket.get().getSchedule())
                    .seat(ticket.get().getSeat())
                    .build();
        }
        return null;
    }

    public TicketResponse delete(int id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            ticket.get().setIsDelete(true);
            ticketRepository.save(ticket.get());
            return new TicketResponse("Ticket was deleted");
        }
        return new TicketResponse("Ticket wasn't deleted");
    }

    public List<TicketDTO> findTicketByPassengerId(int id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        if (passenger.isPresent()) {
            Iterable<Ticket> ticket = ticketRepository.findAllByPassenger(passenger.get());
            List<TicketDTO> ticketDTOList = new ArrayList<>();
            for (Ticket ticket1 : ticket) {
                TicketDTO ticketDTO = TicketDTO.builder()
                        .id(ticket1.getId())
                        .passenger(ticket1.getPassenger())
                        .schedule(ticket1.getSchedule())
                        .seat(ticket1.getSeat())
                        .build();
                ticketDTOList.add(ticketDTO);
            }
            return ticketDTOList;
        }
        return null;
    }

    public List<TicketDTO> findTicketByScheduleId(int id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (schedule.isPresent()) {
            Iterable<Ticket> ticket = ticketRepository.findAllBySchedule(schedule.get());
            List<TicketDTO> ticketDTOList = new ArrayList<>();
            for (Ticket ticket1 : ticket) {
                TicketDTO ticketDTO = TicketDTO.builder()
                        .id(ticket1.getId())
                        .passenger(ticket1.getPassenger())
                        .schedule(ticket1.getSchedule())
                        .seat(ticket1.getSeat())
                        .build();
                ticketDTOList.add(ticketDTO);
            }
            return ticketDTOList;
        }
        return null;
    }
}
