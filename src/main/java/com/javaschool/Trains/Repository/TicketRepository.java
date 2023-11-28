package com.javaschool.Trains.Repository;

import com.javaschool.Trains.Entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket,Integer> {
}
