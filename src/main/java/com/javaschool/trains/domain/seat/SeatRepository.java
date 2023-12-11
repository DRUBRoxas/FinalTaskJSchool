package com.javaschool.trains.domain.seat;

import com.javaschool.trains.domain.train.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
    Iterable<Seat> findAllByTrainNumber(Train train);

    @Modifying()
    @Query("update Seat s set s.seatNumber = :seatNumber, s.trainNumber = :trainNumber where s.id = :id")
    void update(@Param(value="id") int id, @Param(value="seatNumber") Integer seatNumber,
                @Param(value="trainNumber") Train trainNumber);

    Optional<Train> findTrainById(int id);
}
