package com.javaschool.Trains.Controller;

import com.javaschool.Trains.Entity.AppUser;
import com.javaschool.Trains.Entity.Passenger;
import com.javaschool.Trains.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
@RequestMapping(path="/Passenger")
public class PassengerController {
    /**
     *   @Autowired
     *     private AppUserRepository appUserRepository;
     *     private PassengerRepository passengerRepository;
     *
     *     @PostMapping(path="/{useremail}/add")
     *     public @ResponseBody String addNewPassenger (@PathVariable("useremail")String email, @RequestParam String name,
     *                                                  @RequestParam String surname, @RequestParam String date){
     *         Passenger passenger = new Passenger();
     *         passenger.setAppUser(appUserRepository.findByEmail(email));
     *         passenger.setName(name);
     *         passenger.setSurname(surname);
     *         LocalDate birthdate = LocalDate.parse(date);
     *         passenger.setDateBirth(birthdate);
     *         passengerRepository.save(passenger);
     *         return "Saved";
     *     }
     *
     *     @GetMapping(path = "/all")
     *     public @ResponseBody Iterable<Passenger> getAllPassengers() {
     *         return passengerRepository.findAll();
     *     }
     */
}
