package com.javaschool.trains.domain.schedule;

import com.javaschool.trains.domain.station.Station;
import com.javaschool.trains.domain.station.StationRepository;
import com.javaschool.trains.domain.train.Train;
import com.javaschool.trains.domain.train.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ScheduleService {
    @Autowired
    private final ScheduleRepository scheduleRepository;
    private final TrainRepository trainRepository;
    private final StationRepository stationRepository;

    public ScheduleResponse create(ScheduleRequest scheduleRequest){
        Train train= trainRepository.findById(scheduleRequest.getIdTrain());
        Station originStation = stationRepository.findById(scheduleRequest.getIdOriginStation());
        Station departureStation = stationRepository.findById(scheduleRequest.getIdDepartureStation());
        Schedule schedule = Schedule.builder()
                .departureTime(scheduleRequest.getDepartureTime())
                .arrivalTime(scheduleRequest.getArrivalTime())
                .trainNumber(train)
                .originStation(originStation)
                .departureStation(departureStation)
                .isDelete(false)
                .build();

        scheduleRepository.save(schedule);
        return new ScheduleResponse("Schedule added successfully");
    }

    public ScheduleResponse update(ScheduleRequest scheduleRequest){
        Train train= trainRepository.findById(scheduleRequest.getIdTrain());
        Station originStation = stationRepository.findById(scheduleRequest.getIdOriginStation());
        Station departureStation = stationRepository.findById(scheduleRequest.getIdDepartureStation());
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleRequest.getId());
        if (schedule.isPresent()) {
            schedule.get().setDepartureTime(scheduleRequest.getDepartureTime());
            schedule.get().setArrivalTime(scheduleRequest.getArrivalTime());
            schedule.get().setTrainNumber(train);
            schedule.get().setOriginStation(originStation);
            schedule.get().setDepartureStation(departureStation);
            scheduleRepository.save(schedule.get());
            return new ScheduleResponse("Schedule updated successfully");
        }
        return new ScheduleResponse("Schedule not found");
    }

    public ScheduleResponse delete(int id){
        scheduleRepository.deleteById(id);
        return new ScheduleResponse("Schedule deleted successfully");
    }

    public Iterable<ScheduleDTO> findAll() {
        Iterable<Schedule> schedules = scheduleRepository.findAllValid();
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        for (Schedule schedule : schedules) {
            scheduleDTOs.add(ScheduleDTO.builder()
                    .id(schedule.getId())
                    .departureTime(schedule.getDepartureTime())
                    .arrivalTime(schedule.getArrivalTime())
                    .train(schedule.getTrainNumber())
                    .originStation(schedule.getOriginStation())
                    .departureStation(schedule.getDepartureStation())
                    .build());
        }
        return scheduleDTOs;
    }

    public ScheduleDTO find(int id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (schedule.isPresent()) {
            return ScheduleDTO.builder()
                    .id(schedule.get().getId())
                    .departureTime(schedule.get().getDepartureTime())
                    .arrivalTime(schedule.get().getArrivalTime())
                    .train(schedule.get().getTrainNumber())
                    .originStation(schedule.get().getOriginStation())
                    .departureStation(schedule.get().getDepartureStation())
                    .build();
        }
        return null;
    }

    public Iterable<ScheduleDTO> findByOriginStation(String stationName) {
        Optional<Station> station = stationRepository.findByStationName(stationName);
        if (station.isPresent()) {
            Iterable<Schedule> schedules = scheduleRepository.findAllByOriginStation(station.get());
            List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            for (Schedule schedule : schedules) {
                if(!schedule.getIsDelete()){
                    scheduleDTOs.add(ScheduleDTO.builder()
                            .id(schedule.getId())
                            .departureTime(schedule.getDepartureTime())
                            .arrivalTime(schedule.getArrivalTime())
                            .train(schedule.getTrainNumber())
                            .originStation(schedule.getOriginStation())
                            .departureStation(schedule.getDepartureStation())
                            .build());
                }
            }
            return scheduleDTOs;
        }
        return null;
    }

    public Iterable<ScheduleDTO> findByDestinationStation(String stationName) {
        Optional<Station> station = stationRepository.findByStationName(stationName);
        if (station.isPresent()) {
            Iterable<Schedule> schedules = scheduleRepository.findAllByDepartureStation(station.get());
            List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            for (Schedule schedule : schedules) {
                if(!schedule.getIsDelete()){
                    scheduleDTOs.add(ScheduleDTO.builder()
                            .id(schedule.getId())
                            .departureTime(schedule.getDepartureTime())
                            .arrivalTime(schedule.getArrivalTime())
                            .train(schedule.getTrainNumber())
                            .originStation(schedule.getOriginStation())
                            .departureStation(schedule.getDepartureStation())
                            .build());
                }
            }
            return scheduleDTOs;
        }
        return null;
    }

    public Iterable<ScheduleDTO> findByOriginAndDestinationStation(String originStationName, String destinationStationName) {
        Optional<Station> originStation = stationRepository.findByStationName(originStationName);
        Optional<Station> destinationStation = stationRepository.findByStationName(destinationStationName);
        if (originStation.isPresent() && destinationStation.isPresent()) {
            Iterable<Schedule> schedules = scheduleRepository.findAllByOriginStationAndDepartureStation(originStation.get(), destinationStation.get());
            List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            for (Schedule schedule : schedules) {
                if(!schedule.getIsDelete()){
                    scheduleDTOs.add(ScheduleDTO.builder()
                            .id(schedule.getId())
                            .departureTime(schedule.getDepartureTime())
                            .arrivalTime(schedule.getArrivalTime())
                            .train(schedule.getTrainNumber())
                            .originStation(schedule.getOriginStation())
                            .departureStation(schedule.getDepartureStation())
                            .build());
                }
            }
            return scheduleDTOs;
        }
        return null;
    }

    public Iterable<ScheduleDTO> findByTrainNumber(int trainNumber) {
        Train train = trainRepository.findById(trainNumber);
        if (train != null) {
            Iterable<Schedule> schedules = scheduleRepository.findAllByTrainNumber(train);
            List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            for (Schedule schedule : schedules) {
                if(!schedule.getIsDelete()){
                    scheduleDTOs.add(ScheduleDTO.builder()
                            .id(schedule.getId())
                            .departureTime(schedule.getDepartureTime())
                            .arrivalTime(schedule.getArrivalTime())
                            .train(schedule.getTrainNumber())
                            .originStation(schedule.getOriginStation())
                            .departureStation(schedule.getDepartureStation())
                            .build());
                }
            }
            return scheduleDTOs;
        }
        return null;
    }

    public Iterable<ScheduleDTO> findByOriginAndDestinationStationAndTrainNumber(String originStationName, String destinationStationName, int trainNumber) {
        Optional<Station> originStation = stationRepository.findByStationName(originStationName);
        Optional<Station> destinationStation = stationRepository.findByStationName(destinationStationName);
        Optional<Train> train = Optional.ofNullable(trainRepository.findById(trainNumber));
        if (originStation.isPresent() && destinationStation.isPresent() && train.isPresent()) {
            Iterable<Schedule> schedules = scheduleRepository.findAllByOriginStationAndDepartureStationAndTrainNumber(originStation.get(), destinationStation.get(), train.get());
            List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            for (Schedule schedule : schedules) {
                if(!schedule.getIsDelete()){
                    scheduleDTOs.add(ScheduleDTO.builder()
                            .id(schedule.getId())
                            .departureTime(schedule.getDepartureTime())
                            .arrivalTime(schedule.getArrivalTime())
                            .train(schedule.getTrainNumber())
                            .originStation(schedule.getOriginStation())
                            .departureStation(schedule.getDepartureStation())
                            .build());
                }
            }
            return scheduleDTOs;
        }
        return null;
    }

    public Iterable<ScheduleDTO> findByOriginAndDestinationStationAndDepartureTime(String originStationName, String destinationStationName, String departureTime) {
        Optional<Station> originStation = stationRepository.findByStationName(originStationName);
        Optional<Station> destinationStation = stationRepository.findByStationName(destinationStationName);
        if (originStation.isPresent() && destinationStation.isPresent()) {
            Iterable<Schedule> schedules = scheduleRepository.findAllByOriginStationAndDepartureStationAndDepartureTime(originStation.get(), destinationStation.get(), LocalTime.parse(departureTime));
            List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            for (Schedule schedule : schedules) {
                scheduleDTOs.add(ScheduleDTO.builder()
                        .departureTime(schedule.getDepartureTime())
                        .arrivalTime(schedule.getArrivalTime())
                        .train(schedule.getTrainNumber())
                        .originStation(schedule.getOriginStation())
                        .departureStation(schedule.getDepartureStation())
                        .build());
            }
            return scheduleDTOs;
        }
        return null;
    }

    public Iterable<ScheduleDTO> findByTimeBetween(ScheduleSearch search) {
        Iterable<Schedule> results = scheduleRepository.searchSchedule(search.getOrigin(), search.getDestination(), search.getStart(), search.getEnd());
        List<ScheduleDTO> response = new ArrayList<>();
        for (Schedule schedule : results) {
            response.add(new ScheduleDTO(schedule.getId(),
                    schedule.getTrainNumber(),
                    schedule.getDepartureTime(),
                    schedule.getArrivalTime(),
                    schedule.getOriginStation(),
                    schedule.getDepartureStation()));
        }
        return response;
    }

    public Iterable<ScheduleDTO> findByOriginOrDestinationStation(String stationName) {
        Optional<Station> station = stationRepository.findByStationName(stationName);
        if (station.isPresent()) {
            Iterable<Schedule> schedules = scheduleRepository.findAllByOriginStationOrDepartureStation(station.get(), station.get());
            List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            for (Schedule schedule : schedules) {
                scheduleDTOs.add(ScheduleDTO.builder()
                        .id(schedule.getId())
                        .departureTime(schedule.getDepartureTime())
                        .arrivalTime(schedule.getArrivalTime())
                        .train(schedule.getTrainNumber())
                        .originStation(schedule.getOriginStation())
                        .departureStation(schedule.getDepartureStation())
                        .build());
            }
            return scheduleDTOs;
        }
        return null;
    }
}
