package com.javaschool.trains.domain.seat;

import com.javaschool.trains.domain.train.Train;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatRequest {
    int id;
    int seatNumber;
    int idTrain;
}
