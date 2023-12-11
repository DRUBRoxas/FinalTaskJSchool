package com.javaschool.trains.domain.train;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainRepository extends JpaRepository<Train,Integer> {

    Train findById(int id);

    @Query("SELECT t From Train t WHERE t.isDelete != true")
    Iterable<Train> findAllValid();
}
