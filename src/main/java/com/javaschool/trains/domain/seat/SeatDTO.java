package com.javaschool.trains.domain.seat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javaschool.trains.domain.train.Train;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    int id;
    private Integer seatNumber;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Train trainNumber;
}
