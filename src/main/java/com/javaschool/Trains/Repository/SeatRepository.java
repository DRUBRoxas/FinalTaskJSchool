package com.javaschool.Trains.Repository;

import com.javaschool.Trains.Entity.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat,Integer> {
}
