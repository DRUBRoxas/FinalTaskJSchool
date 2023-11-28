package com.javaschool.Trains.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train")
public class Train {
    @Id
    @Column(name = "train_number", nullable = false)
    private Integer id;

    @Column(name = "seats")
    private Short seats;

    @Column(name = "isDelete")
    private Byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getSeats() {
        return seats;
    }

    public void setSeats(Short seats) {
        this.seats = seats;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

}