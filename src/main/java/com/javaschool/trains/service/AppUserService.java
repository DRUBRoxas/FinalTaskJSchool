package com.javaschool.trains.service;

import com.javaschool.trains.entity.AppUser;
import com.javaschool.trains.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    public AppUser create(AppUser appUser){
        return appUserRepository.save(appUser);
    }

    public AppUser update(AppUser appUser){
        return appUserRepository.save(appUser);
    }

    public boolean delete(Integer id){
        if (appUserRepository.existsById(id)){
            appUserRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    public Optional<AppUser> find(Integer id){
        return appUserRepository.findById(id);
    }
}
