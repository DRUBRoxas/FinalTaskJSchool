package com.javaschool.trains.domain.seat;

import com.javaschool.trains.domain.train.Train;
import com.javaschool.trains.domain.train.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {
    @Autowired
    private final SeatRepository seatRepository;
    @Autowired
    private final TrainRepository trainRepository;

    public Iterable<SeatDTO> findAll() {
        Iterable<Seat> seats = seatRepository.findAll();
       List<SeatDTO> seatDTOs = new ArrayList<>();
        for(Seat seat: seats) {
            seatDTOs.add(SeatDTO.builder()
                    .id(seat.getId())
                    .seatNumber(seat.getSeatNumber())
                    .trainNumber(seat.getTrainNumber())
                    .build());
        }
        return seatDTOs;
    }

    public Iterable<SeatDTO> findAllSeatsByTrain(Train train) {
        Iterable<Seat> seats = seatRepository.findAllByTrainNumber(train);
        List<SeatDTO> seatDTOs = new ArrayList<>();
        for(Seat seat: seats) {
            seatDTOs.add(SeatDTO.builder()
                    .id(seat.getId())
                    .seatNumber(seat.getSeatNumber())
                    .trainNumber(seat.getTrainNumber())
                    .build());
        }
        return seatDTOs;
    }

    public SeatDTO findSeatById(int id) {
        Optional<Seat> seat = seatRepository.findById(id);
        return seat.map(value -> SeatDTO.builder()
                .id(value.getId())
                .seatNumber(value.getSeatNumber())
                .trainNumber(value.getTrainNumber())
                .build()).orElse(null);
    }

    public SeatResponse createSeat(SeatRequest seatRequest,int idTrain) {
        Train train = trainRepository.findById(idTrain);
        Seat seat = Seat.builder()
                .seatNumber(seatRequest.getSeatNumber())
                .trainNumber(train)
                .build();
        seatRepository.save(seat);
        return new SeatResponse("Seat saved");
    }

    public SeatResponse createSeatAuto(int idTrain){
        Train train= trainRepository.findById(idTrain);
        Iterable<Seat> seats = seatRepository.findAllByTrainNumber(train);
        int seatNumber= IterableUtils.size(seats)+1;
        Seat seat = Seat.builder()
                .seatNumber(seatNumber)
                .trainNumber(trainRepository.findById(idTrain))
                .build();
        seatRepository.save(seat);
        train.setSeats(seatNumber);
        trainRepository.save(train);
        return new SeatResponse("Seat saved");
    }

    public SeatResponse deleteSeat(int id) {
        seatRepository.deleteById(id);
        return new SeatResponse("Seat deleted");
    }


}
