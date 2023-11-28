package com.javaschool.Trains.Controller;

import com.javaschool.Trains.Entity.AppUser;
import com.javaschool.Trains.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/appuser")
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String email, @RequestParam String password, @RequestParam String role){
        AppUser user = new AppUser();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        appUserRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }
}
