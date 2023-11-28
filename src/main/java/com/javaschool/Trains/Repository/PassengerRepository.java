package com.javaschool.Trains.Repository;

import com.javaschool.Trains.Entity.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger,Integer> {
}
