package com.javaschool.trains.repository;
import org.springframework.data.repository.CrudRepository;
import com.javaschool.trains.entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Integer>{
    //This will be auto Implemented by Spring into a Bean

}
