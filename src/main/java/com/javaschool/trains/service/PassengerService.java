package com.javaschool.trains.service;

import com.javaschool.trains.entity.Passenger;
import com.javaschool.trains.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    public Passenger create(Passenger passenger){
        return passengerRepository.save(passenger);
    }

    public Passenger update(Passenger passenger){
        return passengerRepository.save(passenger);
    }

    public boolean delete(Passenger passenger){
        if(!passenger.getIsDelete()){
            passenger.setIsDelete(true);
            passengerRepository.save(passenger);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Passenger> find(Integer id){
        return passengerRepository.findById(id);
    }
}