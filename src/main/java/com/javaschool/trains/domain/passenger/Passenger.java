package com.javaschool.trains.domain.passenger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javaschool.trains.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "appUser", nullable = false)
    private User user;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "lastname", nullable = false, length = 80)
    private String lastname;

    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Column(name = "isDelete")
    private Boolean isDelete;

}