package com.javaschool.trains.domain.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket create(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket update(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public boolean delete(Ticket ticket){
        if(!ticket.getIsDelete()){
            ticket.setIsDelete(true);
            ticketRepository.save(ticket);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Ticket> find(Integer id){
        return ticketRepository.findById(id);
    }
}
