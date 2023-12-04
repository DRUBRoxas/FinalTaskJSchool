package com.javaschool.trains.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value="{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Integer id){
        if(userService.find(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.find(id));
    }
    @GetMapping(path = "all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.allUsers();
    }

}
