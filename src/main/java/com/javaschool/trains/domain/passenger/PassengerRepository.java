package com.javaschool.trains.domain.passenger;

import com.javaschool.trains.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

    Iterable<Passenger> findAllByUser(User user);
    @Modifying()
    @Query("update Passenger p set p.name = :name, p.lastname = :lastname, p.dateBirth = :dateBirth where p.id = :id")
    void update(@Param(value="id") int id, @Param(value="name") String name,
                @Param(value="lastname") String lastname,
                @Param(value="dateBirth") LocalDate dateBirth);

    @Query("SELECT p FROM Passenger p WHERE p.isDelete != true")
    Iterable<Passenger> findAllValid();
}
