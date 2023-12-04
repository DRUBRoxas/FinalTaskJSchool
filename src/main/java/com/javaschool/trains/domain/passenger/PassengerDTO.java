package com.javaschool.trains.domain.passenger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javaschool.trains.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
    int id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    User user;
    String name;
    String lastname;
    LocalDate dateBirth;
}
