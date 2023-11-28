package com.javaschool.trains.repository;

import com.javaschool.trains.entity.Train;
import org.springframework.data.repository.CrudRepository;

public interface TrainRepository extends CrudRepository<Train,Integer> {
}
