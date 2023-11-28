package com.javaschool.trains.repository;

import com.javaschool.trains.entity.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Integer> {
}
