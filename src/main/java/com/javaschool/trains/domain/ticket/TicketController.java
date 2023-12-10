package com.javaschool.trains.domain.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/api/ticket")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping(path="/add")
    public ResponseEntity<TicketResponse> create(@RequestBody TicketRequest ticketRequest){
        TicketResponse ticketResponse = ticketService.create(ticketRequest);
        if (ticketResponse == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticketResponse);
    }

    @GetMapping(path="/all")
    public ResponseEntity<Iterable<TicketDTO>> getAllTickets() {
        List<TicketDTO> ticket = ticketService.findAll();
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticket);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Integer id) {
        TicketDTO ticket = ticketService.findTicketById(id);
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticket);
    }

    @GetMapping(path="/passenger/{id}")
    public ResponseEntity<Iterable<TicketDTO>> getTicketByPassengerId(@PathVariable int id) {
        List<TicketDTO> ticket = ticketService.findTicketByPassengerId(id);
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticket);
    }

    @GetMapping(path="/schedule/{id}")
    public ResponseEntity<Iterable<TicketDTO>> getTicketByScheduleId(@PathVariable int id) {
        List<TicketDTO> ticket = ticketService.findTicketByScheduleId(id);
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticket);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<TicketResponse> delete(@PathVariable int id) {
        TicketResponse ticketResponse = ticketService.delete(id);
        if (ticketResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticketResponse);
    }
}
