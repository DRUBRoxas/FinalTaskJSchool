package com.javaschool.trains.domain.train;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/train")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;

    @GetMapping(value="/all")
    public ResponseEntity<Iterable<TrainDTO>> getAllTrains() {
        Iterable<TrainDTO> trainDTO = trainService.findAll();
        if (trainDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trainDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<TrainDTO> getTrain(int id) {
        TrainDTO trainDTO = trainService.getTrainById(id);
        if (trainDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trainDTO);
    }

    @PutMapping(value="/update")
    public ResponseEntity<TrainResponse> updateTrain(@RequestBody TrainRequest trainRequest) {
        TrainResponse trainResponse = trainService.updateTrain(trainRequest);
        if (trainResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trainResponse);
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity<TrainResponse> deleteTrain(@RequestBody TrainRequest trainRequest) {
        TrainResponse trainResponse = trainService.deleteTrain(trainRequest);
        if (trainResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trainResponse);
    }

    @PostMapping(value="/add")
    public ResponseEntity<TrainResponse> createTrain(@RequestBody TrainRequest trainRequest) {
        TrainResponse trainResponse = trainService.createTrain(trainRequest);
        if (trainResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trainResponse);
    }
}
