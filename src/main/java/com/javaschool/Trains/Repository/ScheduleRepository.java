package com.javaschool.Trains.Repository;

import com.javaschool.Trains.Entity.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}
