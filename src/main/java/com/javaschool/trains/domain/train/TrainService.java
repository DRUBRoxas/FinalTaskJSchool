package com.javaschool.trains.domain.train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainService {
    @Autowired
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }

    public Train create(Train train){
        return trainRepository.save(train);
    }

    public Train update(Train train){
        return trainRepository.save(train);
    }


    //TODO borrado recursivo
    public boolean delete(Train train){
        if(!train.getIsDelete()){
            train.setIsDelete(true);
            trainRepository.save(train);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Train> find(Integer id){
        return trainRepository.findById(id);
    }
}
