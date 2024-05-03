package com.banzo.study.yolozeee.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banzo.study.yolozeee.data.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    // get all colums by res_date
    List<Reservation> findByReservationDate(LocalDate reservationDate);
}
