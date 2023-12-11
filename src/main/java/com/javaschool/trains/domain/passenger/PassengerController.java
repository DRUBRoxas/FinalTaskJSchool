package com.javaschool.trains.domain.passenger;

import com.javaschool.trains.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/passenger")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PassengerController {
    private final PassengerService passengerService;

    @GetMapping(value = "{id}")
    public ResponseEntity<PassengerDTO> getPassenger(@PathVariable Integer id)
    {
        PassengerDTO passengerDTO = passengerService.find(id);
        if (passengerDTO==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerDTO);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<PassengerResponse> updatePassenger(@RequestBody PassengerRequest passengerRequest)
    {
        PassengerResponse passengerResponse = passengerService.updatePassenger(passengerRequest);
        if (passengerResponse==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerResponse);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<PassengerResponse> createPassenger(@RequestBody PassengerRequest passengerRequest)
    {
        PassengerResponse passengerResponse = passengerService.createPassenger(passengerRequest);
        if (passengerResponse==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerResponse);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<PassengerDTO>> getAllPassengers()
    {
        Iterable<PassengerDTO> passengerDTO = passengerService.findAll();
        if (passengerDTO==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerDTO);
    }

    @GetMapping(value = "/all/user")
    public ResponseEntity<Iterable<PassengerDTO>> getAllPassengersofUser()
    {
        Object loggedUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Iterable<PassengerDTO> passengerDTO = passengerService.findAllOfUser((User) loggedUser);
        if (passengerDTO==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerDTO);
    }
}
