package com.javaschool.trains.repository;

import com.javaschool.trains.entity.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger,Integer> {
}
