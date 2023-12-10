package com.javaschool.trains.domain.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javaschool.trains.domain.station.Station;
import com.javaschool.trains.domain.train.Train;
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
public class ScheduleDTO {
    int id;
    Train train;
    LocalTime departureTime;
    LocalTime arrivalTime;
    Station originStation;
    Station departureStation;
}
