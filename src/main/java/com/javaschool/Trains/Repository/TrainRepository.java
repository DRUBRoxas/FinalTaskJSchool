package com.javaschool.Trains.Repository;

import com.javaschool.Trains.Entity.Train;
import org.springframework.data.repository.CrudRepository;

public interface TrainRepository extends CrudRepository<Train,Integer> {
}
