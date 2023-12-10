package com.javaschool.trains.domain.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/schedule")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping(path="/all")
    public ResponseEntity<Iterable<ScheduleDTO>> getAllSchedules() {
        Iterable<ScheduleDTO> scheduleDTOS= scheduleService.findAll();
        if (scheduleDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleDTOS);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable int id) {
        ScheduleDTO scheduleDTO = scheduleService.find(id);
        if (scheduleDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleDTO);
    }

    @PostMapping(path="/add")
    public ResponseEntity<ScheduleResponse> createSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        ScheduleResponse scheduleResponse = scheduleService.create(scheduleRequest);
        if (scheduleResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleResponse);
    }

    @PutMapping(path="/update")
    public ResponseEntity<ScheduleResponse> updateSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        ScheduleResponse scheduleResponse = scheduleService.update(scheduleRequest);
        if (scheduleResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleResponse);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<ScheduleResponse> deleteSchedule(@PathVariable int id) {
        ScheduleResponse scheduleResponse = scheduleService.delete(id);
        if (scheduleResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleResponse);
    }

    @GetMapping(path="/filtered/origin/{stationName}")
    public ResponseEntity<Iterable<ScheduleDTO>> getScheduleByOriginStation(@PathVariable String stationName) {
        Iterable<ScheduleDTO> scheduleDTOS = scheduleService.findByOriginStation(stationName);
        if (scheduleDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleDTOS);
    }

    @GetMapping(path="/filtered/destination/{stationName}")
    public ResponseEntity<Iterable<ScheduleDTO>> getScheduleByDestinationStation(@PathVariable String stationName) {
        Iterable<ScheduleDTO> scheduleDTOS = scheduleService.findByDestinationStation(stationName);
        if (scheduleDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleDTOS);
    }

    @GetMapping(path="/filtered/origin={originStationName}+destination={destinationStationName}")
    public ResponseEntity<Iterable<ScheduleDTO>> getScheduleByOriginAndDestinationStation(@PathVariable String originStationName, @PathVariable String destinationStationName) {
        Iterable<ScheduleDTO> scheduleDTOS = scheduleService.findByOriginAndDestinationStation(originStationName, destinationStationName);
        if (scheduleDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleDTOS);
    }

    @GetMapping(path="/filtered/train/{trainNumber}")
    public ResponseEntity<Iterable<ScheduleDTO>> getScheduleByTrainNumber(@PathVariable int trainNumber) {
        Iterable<ScheduleDTO> scheduleDTOS = scheduleService.findByTrainNumber(trainNumber);
        if (scheduleDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleDTOS);
    }

    @GetMapping(path="/filtered/all/origin={originStationName}+destination={destinationStationName}+train={trainNumber}")
    public ResponseEntity<Iterable<ScheduleDTO>> getScheduleByOriginAndDestinationStationAndTrainNumber(@PathVariable String originStationName, @PathVariable String destinationStationName, @PathVariable int trainNumber) {
        Iterable<ScheduleDTO> scheduleDTOS = scheduleService.findByOriginAndDestinationStationAndTrainNumber(originStationName, destinationStationName, trainNumber);
        if (scheduleDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleDTOS);
    }

    @GetMapping(path="/filtered/all/origin={originStationName}+destination={destinationStationName}+departureTime={departureTime}")
    public ResponseEntity<Iterable<ScheduleDTO>> getScheduleByOriginAndDestinationStationAndDepartureTime(@PathVariable String originStationName, @PathVariable String destinationStationName, @PathVariable String departureTime) {
        departureTime = departureTime.replace("%3A", ":");
        Iterable<ScheduleDTO> scheduleDTOS = scheduleService.findByOriginAndDestinationStationAndDepartureTime(originStationName,
                destinationStationName, departureTime);
        if (scheduleDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleDTOS);
    }
}

