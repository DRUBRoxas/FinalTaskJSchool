package com.javaschool.trains.domain.station;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/station")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class StationController {
    @Autowired
    private final StationService stationService;

    @GetMapping(path="/all")
    public ResponseEntity<Iterable<StationDTO>> getAllStations() {
        Iterable<StationDTO> stationDTO = stationService.findAll();
        if (stationDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stationDTO);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<StationDTO> getStation(@PathVariable int id) {
        StationDTO stationDTO = stationService.getStationById(id);
        if (stationDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stationDTO);
    }

    @PutMapping(value="/update")
    public ResponseEntity<StationResponse> updateStation(@RequestBody StationRequest stationRequest) {
        StationResponse stationResponse = stationService.updateStation(stationRequest);
        if (stationResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stationResponse);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<StationResponse> createStation(@RequestBody StationRequest stationRequest) {
        StationResponse stationResponse = stationService.createStation(stationRequest);
        if (stationResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stationResponse);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<StationResponse> deleteStation(@PathVariable int id) {
        StationResponse stationResponse = stationService.deleteStation(id);
        if (stationResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stationResponse);
    }


}
