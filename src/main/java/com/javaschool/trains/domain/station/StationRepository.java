package com.javaschool.trains.domain.station;

import com.javaschool.trains.domain.train.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Integer> {
    Optional<Station> findByStationName(String stationName);
    Station findById(int id);
    @Modifying
    @Query("update Station s set s.stationName = :stationName where s.id = :id")
    void update(@Param(value="id")int id,@Param("stationName") String stationName);

    Optional<Station> findAllByStationName(String stationName);
}
