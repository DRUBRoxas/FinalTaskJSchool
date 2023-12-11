package com.javaschool.trains.domain.passenger;

import com.javaschool.trains.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {
    @Autowired
    private final PassengerRepository passengerRepository;

    public PassengerResponse createPassenger(PassengerRequest passengerRequest){
        Object loggedUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Passenger passenger= Passenger.builder()
                .name(passengerRequest.name)
                .user((User) loggedUser)
                .lastname(passengerRequest.lastname)
                .dateBirth(LocalDate.from(passengerRequest.dateBirth))
                .build();
        passengerRepository.save(passenger);
        return new PassengerResponse("Passenger created");
    }

    public PassengerResponse updatePassenger(PassengerRequest passengerRequest){
        Object loggedUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Passenger passenger= Passenger.builder()
                .name(passengerRequest.name)
                .user((User) loggedUser)
                .lastname(passengerRequest.lastname)
                .dateBirth(passengerRequest.dateBirth)
                .build();
        passengerRepository.update(passenger.getId(),passenger.getName(),passenger.getLastname(),passenger.getDateBirth());
        return new PassengerResponse("Passenger updated");
    }
    public boolean delete(Passenger passenger){
        if(Boolean.FALSE.equals(passenger.getIsDelete())){
            passenger.setIsDelete(true);
            passengerRepository.save(passenger);
            return true;
        }else{
            return false;
        }
    }

    public PassengerDTO find(Integer id){
        Passenger passenger= passengerRepository.findById(id).orElse(null);
        if(passenger!=null){
           return PassengerDTO.builder()
                    .id(passenger.getId())
                    .name(passenger.getName())
                    .lastname(passenger.getLastname())
                    .dateBirth(passenger.getDateBirth())
                    .build();
        }
        return null;
    }

    public Iterable<PassengerDTO> findAll(){
        Iterable<Passenger> passengers = passengerRepository.findAll();
        List<PassengerDTO> passengerDTOS = new ArrayList<>();
        for(Passenger passenger:passengers){
            passengerDTOS.add(
                    PassengerDTO.builder()
                            .id(passenger.getId())
                            .name(passenger.getName())
                            .user(passenger.getUser())
                            .lastname(passenger.getLastname())
                            .dateBirth(passenger.getDateBirth())
                            .build()
            );
        }
        return passengerDTOS;
    }

    public Iterable<PassengerDTO> findAllOfUser(User user) {
        Iterable<Passenger> passengers = passengerRepository.findAllByUser(user);
        List<PassengerDTO> passengerDTOS = new ArrayList<>();
        for (Passenger passenger : passengers) {
            passengerDTOS.add(
                    PassengerDTO.builder()
                            .id(passenger.getId())
                            .name(passenger.getName())
                            .user(passenger.getUser())
                            .lastname(passenger.getLastname())
                            .dateBirth(passenger.getDateBirth())
                            .build()
            );
        }
            return passengerDTOS;
        }


}