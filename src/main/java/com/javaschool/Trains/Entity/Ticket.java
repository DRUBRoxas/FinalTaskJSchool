package com.javaschool.Trains.Entity;

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
    private Byte isDelete;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_idSchedule", nullable = false)
    private Schedule scheduleIdschedule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passengerID", nullable = false)
    private Passenger passengerUserEmail;

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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Schedule getScheduleIdschedule() {
        return scheduleIdschedule;
    }

    public void setScheduleIdschedule(Schedule scheduleIdschedule) {
        this.scheduleIdschedule = scheduleIdschedule;
    }

    public Passenger getPassengerUserEmail() {
        return passengerUserEmail;
    }

    public void setPassengerUserEmail(Passenger passengerUserEmail) {
        this.passengerUserEmail = passengerUserEmail;
    }

}