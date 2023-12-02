package com.javaschool.trains.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public boolean delete(Integer id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    public Optional<User> find(Integer id){
        return userRepository.findById(id);
    }
}
