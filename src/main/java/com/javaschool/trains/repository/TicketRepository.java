package com.javaschool.trains.repository;

import com.javaschool.trains.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket,Integer> {
}
