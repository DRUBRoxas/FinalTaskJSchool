package com.javaschool.trains.domain.train;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainService {
    @Autowired
    private final TrainRepository trainRepository;

    public TrainResponse createTrain(TrainRequest trainRequest) {
        Train train = Train.builder()
                .id(trainRequest.getId())
                .build();
        trainRepository.save(train);
        return new TrainResponse("Train saved");
    }

    public TrainResponse updateTrain(TrainRequest trainRequest) {
        Train train = Train.builder()
                .id(trainRequest.getId())
                .build();
        trainRepository.update(train.getId());
        return new TrainResponse("Train updated");
    }

    public TrainDTO getTrainById(int id) {
        Train train = trainRepository.findById(id);
        return TrainDTO.builder()
                .id(train.getId())
                .build();
    }


    public Iterable<TrainDTO> findAll() {
        Iterable<Train> trains = trainRepository.findAll();
        List<TrainDTO> trainsDTO = new ArrayList<>();
        for(Train train: trains) {
            trainsDTO.add(TrainDTO.builder()
                    .id(train.getId())
                    .build());
        }
        return trainsDTO;
    }

    public TrainResponse deleteTrain(TrainRequest trainRequest) {
        Train train = Train.builder()
                .id(trainRequest.getId())
                .build();
        trainRepository.delete(train);
        return new TrainResponse("Train deleted");
    }
}

