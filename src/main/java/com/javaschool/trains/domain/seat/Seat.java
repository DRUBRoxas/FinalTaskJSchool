package com.javaschool.trains.domain.seat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javaschool.trains.domain.train.Train;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue()
    @Column(name = "idseat", nullable = false)
    private Integer id;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "train_number", nullable = false)
    private Train trainNumber;

}