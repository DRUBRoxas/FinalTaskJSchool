package com.javaschool.trains.domain.schedule;

import com.javaschool.trains.domain.station.Station;
import com.javaschool.trains.domain.train.Train;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    @Modifying()
    @Query("update Schedule s set s.trainNumber = :train, s.arrivalTime = :arrivalTime, s.departureTime = :departureTime, s.originStation = :originStation, s.departureStation = :departureStation where s.id = :id")
    void update(@Param(value="id") Integer id, @Param(value="train") Train train,
                @Param(value="arrivalTime") LocalTime arrivalTime,
                @Param(value="departureTime") LocalTime departureTime,
                @Param(value="originStation") Station originStation,
                @Param(value="departureStation") Station departureStation);

    Iterable<Schedule> findAllByTrainNumber(Train train);

    Iterable<Schedule> findAllByOriginStation(Station station);

    Iterable<Schedule> findAllByDepartureStation(Station station);

    Iterable<Schedule> findAllByOriginStationAndDepartureStation(Station originStation, Station departureStation);

    Iterable<Schedule> findAllByOriginStationAndDepartureStationAndTrainNumber(Station station, Station station1, Train train);

    Iterable<Schedule> findAllByOriginStationAndDepartureStationAndDepartureTime(Station station, Station station1, LocalTime parse);
}
