package com.javaschool.trains.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String email, @RequestParam String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.USER);
        userRepository.save(user);
        return "Saved";
    }

    @PostMapping(path = "all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
