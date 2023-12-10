package com.javaschool.trains.domain.station;
import com.javaschool.trains.domain.passenger.PassengerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService {
    @Autowired
    private final StationRepository stationRepository;

    public StationDTO getStationById(int id) {
        Station station = stationRepository.findById(id);
        return StationDTO.builder()
                .id(station.getId())
                .stationName(station.getStationName())
                .build();
    }

    public Iterable<StationDTO> findAll() {
        Iterable<Station> stations = stationRepository.findAll();
        List<StationDTO> stationDTOs = new ArrayList<>();
        for(Station station: stations) {
            stationDTOs.add(StationDTO.builder()
                    .id(station.getId())
                    .stationName(station.getStationName())
                    .build());
        }
        return stationDTOs;

    }

    public StationDTO getStationByName(String stationName) {
        Optional<Station> station = stationRepository.findByStationName(stationName);
        return station.map(value -> StationDTO.builder()
                .id(value.getId())
                .stationName(value.getStationName())
                .build()).orElse(null);
    }

    public StationResponse createStation(StationRequest stationRequest) {
        Station station = Station.builder()
                .stationName(stationRequest.getStationName())
                .build();
        stationRepository.save(station);
        return new StationResponse("Station saved");
    }

    public StationResponse updateStation(StationRequest stationRequest) {
        Station station = Station.builder()
                .id(stationRequest.getId())
                .stationName(stationRequest.getStationName())
                .build();
        stationRepository.update(station.getId(), station.getStationName());
        return new StationResponse("Station updated");
    }


    public StationResponse deleteStation(Integer id) {
        Station station = stationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Station Id:" + id));
        if(station!= null) {
            stationRepository.delete(station);
        }
        return new StationResponse("Station deleted");
    }
}
