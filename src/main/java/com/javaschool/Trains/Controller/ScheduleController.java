package com.javaschool.Trains.Controller;

import com.javaschool.Trains.Entity.AppUser;
import com.javaschool.Trains.Entity.Schedule;
import com.javaschool.Trains.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@Controller
@RequestMapping(path="/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewSchedule (@RequestParam LocalTime departureTime,@RequestParam LocalTime arrivalTime,
                                                @RequestParam Integer departure_station_id, @RequestParam Integer origin_station_id,
                                                @RequestParam Integer trainNumber){

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Schedule> getAllUsers() {
        return scheduleRepository.findAll();
    }

}

