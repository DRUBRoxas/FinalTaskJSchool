package com.javaschool.trains.domain.station;

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
@Table(name = "station", uniqueConstraints = {@UniqueConstraint(columnNames = {"stationName"})})
public class Station {
    @Id
    @GeneratedValue()
    @Column(name = "stationId", nullable = false)
    private Integer id;

    @Column(name = "stationName", nullable = false, length = 70)
    private String stationName;

    @Column(name = "isDelete")
    private Boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

}