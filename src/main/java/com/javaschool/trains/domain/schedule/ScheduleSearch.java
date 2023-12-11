package com.javaschool.trains.domain.schedule;

import lombok.*;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleSearch {

    private int origin = -1;
    private int destination = -1;
    private LocalTime start = null;
    private LocalTime end = null;
}
