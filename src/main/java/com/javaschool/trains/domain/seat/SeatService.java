package com.javaschool.trains.domain.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatService {
    @Autowired
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    public Seat create(Seat seat){
        return seatRepository.save(seat);
    }

    public Seat update(Seat seat){
        return seatRepository.save(seat);
    }

    public boolean delete(Integer id){
        if(seatRepository.existsById(id)){
            seatRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Seat> find(Integer id){
        return seatRepository.findById(id);
    }
}
