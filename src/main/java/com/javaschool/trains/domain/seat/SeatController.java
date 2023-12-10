package com.javaschool.trains.domain.seat;

import com.javaschool.trains.domain.station.StationDTO;
import com.javaschool.trains.domain.train.Train;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/seat")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor

public class SeatController {
    @Autowired
    private final SeatService seatService;

    @GetMapping(path="/all")
    public ResponseEntity<Iterable<SeatDTO>> getAllSeats() {
        Iterable<SeatDTO> seatDTO = seatService.findAll();
        if (seatDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seatDTO);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<SeatDTO> getSeat(int id) {
        SeatDTO seatDTO = seatService.findSeatById(id);
        if (seatDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seatDTO);
    }

    @GetMapping(path="/{trainNumber}")
    public ResponseEntity<Iterable<SeatDTO>> getAllSeatsByTrain(@PathVariable Train trainNumber) {
        Iterable<SeatDTO> seatDTO = seatService.findAllSeatsByTrain(trainNumber);
        if (seatDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seatDTO);
    }

    @PostMapping(value = "/{trainNumber}/add")
    public ResponseEntity<SeatResponse> createSeat(@RequestBody SeatRequest seatRequest,@PathVariable int trainNumber) {
        SeatResponse seatResponse = seatService.createSeat(seatRequest,trainNumber);
        if (seatResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seatResponse);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<SeatResponse> deleteSeat(@RequestBody SeatRequest seatRequest) {
        SeatResponse seatResponse = seatService.deleteSeat(seatRequest.getId());
        if (seatResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seatResponse);
    }

}
