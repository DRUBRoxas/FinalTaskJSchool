package com.javaschool.trains.domain.schedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javaschool.trains.domain.station.Station;
import com.javaschool.trains.domain.train.Train;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSchedule", nullable = false)
    private Integer id;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm")
    @Column(name = "departureTime", nullable = false)
    private LocalTime departureTime;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm")
    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "departureStation", nullable = false)
    private Station departureStation;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "originStation", nullable = false)
    private Station originStation;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "train_Number", nullable = false)
    private Train trainNumber;

    @Column(name = "isDelete")
    private Boolean isDelete;

}