package com.banzo.study.yolozeee.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banzo.study.yolozeee.data.repository.GuestRepository;
import com.banzo.study.yolozeee.data.repository.ReservationRepository;
import com.banzo.study.yolozeee.data.repository.RoomRepository;
import com.banzo.study.yolozeee.service.model.RoomReservation;

import io.micrometer.common.util.StringUtils;

@Service
public class RoomReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public RoomReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
            ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(String reservationDate) {
        Date date = null;

        if(StringUtils.isNotEmpty(reservationDate)) {
            date = Date.valueOf(reservationDate);
        } else {
            date = new Date(new java.util.Date().getTime());
        }
    }
}
