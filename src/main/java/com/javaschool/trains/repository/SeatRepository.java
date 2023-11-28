package com.javaschool.trains.repository;

import com.javaschool.trains.entity.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat,Integer> {
}
