package com.javaschool.trains.domain.train;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "train")
public class Train {
    @Id
    @Column(name = "train_number", nullable = false)
    private Integer id;

    @Column(name = "isDelete")
    private Boolean isDelete;

    @Column(name = "train_seats")
    private int seats;

}