package com.javaschool.trains.domain.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequest {
    int id;
    LocalTime departureTime;
    LocalTime arrivalTime;
    int idTrain;
    int idOriginStation;
    int idDepartureStation;
}
