package com.banzo.study.yolozeee.web.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banzo.study.yolozeee.service.RoomReservationService;

import io.micrometer.common.util.StringUtils;

@Controller
@RequestMapping("/rooms/reservation")
public class RoomReservationController {
    private final RoomReservationService roomReservationService;

    public RoomReservationController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public String getRoomReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = null;
        
        if(StringUtils.isNotEmpty(dateString)) {
            date = Date.valueOf(dateString);
        } else {
            date = new Date(new java.util.Date().getTime());
        }

        model.addAttribute("date", date);
        model.addAttribute("roomReservation", this.roomReservationService.getRoomReservationsForDate(dateString));
        return "room-reservation-on-date";
    }

}
