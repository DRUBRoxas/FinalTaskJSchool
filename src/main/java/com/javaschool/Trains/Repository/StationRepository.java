package com.javaschool.Trains.Repository;

import com.javaschool.Trains.Entity.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Integer> {
}
