package com.javaschool.Trains.Repository;
import org.springframework.data.repository.CrudRepository;
import com.javaschool.Trains.Entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Integer>{
    //This will be auto Implemented by Spring into a Bean

}
