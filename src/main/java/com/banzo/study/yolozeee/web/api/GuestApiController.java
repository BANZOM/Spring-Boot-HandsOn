package com.banzo.study.yolozeee.web.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banzo.study.yolozeee.data.entity.Guest;
import com.banzo.study.yolozeee.data.repository.GuestRepository;
import com.banzo.study.yolozeee.web.exception.NotFoundException;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {

    public final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> getGuests() {
        return this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(long id) {
        return this.guestRepository.findById(id).orElseThrow(() -> new NotFoundException("Guest not found with id: " + id));
    }

}
