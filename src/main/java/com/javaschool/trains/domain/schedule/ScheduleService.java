package com.javaschool.trains.domain.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule create(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public Schedule update(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public boolean delete(Schedule schedule){
        if(!schedule.getIsDelete()){
            schedule.setIsDelete(true);
            scheduleRepository.save(schedule);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Schedule> find(Integer id){
        return scheduleRepository.findById(id);
    }
}
