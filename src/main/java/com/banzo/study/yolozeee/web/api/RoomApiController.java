package com.banzo.study.yolozeee.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banzo.study.yolozeee.data.entity.Room;
import com.banzo.study.yolozeee.data.repository.RoomRepository;
import com.banzo.study.yolozeee.web.exception.BadRequestException;
import com.banzo.study.yolozeee.web.exception.NotFoundException;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {
    private final RoomRepository roomRepository;

    public RoomApiController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getRooms() {
        return this.roomRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room room) {
        return this.roomRepository.save(room);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") long id) {
        return this.roomRepository.findById(id).orElseThrow(() -> new NotFoundException("Room not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable("id") long id, @RequestBody Room room) {
        this.roomRepository.findById(id).orElseThrow(() -> new BadRequestException("Room not found with id: " + id));
        return this.roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable("id") long id) {
        this.roomRepository.deleteById(id);
    }

}
