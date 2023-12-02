package com.javaschool.trains.domain.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StationService {
    @Autowired
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository){
        this.stationRepository = stationRepository;
    }

    public Station create(Station station){
        return stationRepository.save(station);
    }

    public Station update(Station station){
        return stationRepository.save(station);
    }

    public boolean delete(Station station){
        if(Boolean.FALSE.equals(station.getIsDelete())){
            station.setIsDelete(true);
            stationRepository.save(station);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Station> find(Integer id){
        return stationRepository.findById(id);
    }
}
