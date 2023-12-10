package com.javaschool.trains.domain.train;

import com.javaschool.trains.domain.seat.SeatRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train,Integer> {
    @Modifying
    @Query("update Train t set t.isDelete = true where t.id = :id")
    void update(@Param(value="id")int id);

    Train findById(int id);


}
