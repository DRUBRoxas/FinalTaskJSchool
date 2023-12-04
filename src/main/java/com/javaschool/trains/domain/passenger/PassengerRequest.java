package com.javaschool.trains.domain.passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {
    int id;
    String name;
    String lastname;
    LocalDate dateBirth;
}