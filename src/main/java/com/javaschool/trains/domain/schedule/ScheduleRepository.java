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

    Iterable<Schedule> findAllByOriginStationOrDepartureStation(Station station, Station station1);

    @Query ("SELECT s FROM Schedule s WHERE s.isDelete != true")
    Iterable<Schedule> findAllValid();

    @Query (value = "SELECT * FROM schedule s WHERE (s.origin_station = :origin OR :origin = -1) AND " +
            "(s.departure_station = :destination OR :destination = -1) AND " +
            "(s.departure_time >= :start OR :start IS null) AND " +
            "(s.arrival_time <= :end OR :end IS null)", nativeQuery = true)
    Iterable<Schedule> searchSchedule(@Param("origin") int origin,
                                      @Param("destination") int destination,
                                      @Param("start") LocalTime start,
                                      @Param("end") LocalTime end);
}
