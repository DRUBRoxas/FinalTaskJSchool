package com.javaschool.trains.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTicket", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seats_idseat", nullable = false)
    private Seat seatsIdseat;

    @Column(name = "isDelete")
    private Boolean isDelete;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_idSchedule", nullable = false)
    private Schedule scheduleIdschedule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passengerID", nullable = false)
    private Passenger passengerUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Seat getSeatsIdseat() {
        return seatsIdseat;
    }

    public void setSeatsIdseat(Seat seatsIdseat) {
        this.seatsIdseat = seatsIdseat;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Schedule getScheduleIdschedule() {
        return scheduleIdschedule;
    }

    public void setScheduleIdschedule(Schedule scheduleIdschedule) {
        this.scheduleIdschedule = scheduleIdschedule;
    }

    public Passenger getPassengerUserEmail() {
        return passengerUser;
    }

    public void setPassengerUserEmail(Passenger passengerUser) {
        this.passengerUser = passengerUser;
    }

}