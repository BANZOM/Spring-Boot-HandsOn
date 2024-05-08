package com.banzo.study.yolozeee.web.api;


import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banzo.study.yolozeee.data.entity.Reservation;
import com.banzo.study.yolozeee.data.repository.ReservationRepository;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getReservations(@RequestParam(value = "date", required = false) String datesString) {
        if (StringUtils.isNotBlank(datesString)) {
            Date date = Date.valueOf(datesString);
            return this.reservationRepository.findByReservationDate(date);
        }
        return this.reservationRepository.findAll();
    }

}
