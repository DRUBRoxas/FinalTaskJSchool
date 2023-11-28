package com.javaschool.trains.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "passenger_id", nullable = false)
    private int passengerid;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appUser", nullable = false)
    private AppUser appUser;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "surname", nullable = false, length = 80)
    private String surname;

    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Column(name = "isDelete")
    private Boolean isDelete;

    public int getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(int passengerid) { this.passengerid = passengerid; }
    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

}