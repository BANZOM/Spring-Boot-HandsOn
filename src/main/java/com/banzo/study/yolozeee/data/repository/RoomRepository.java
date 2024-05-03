package com.banzo.study.yolozeee.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banzo.study.yolozeee.data.entity.Room;


public interface RoomRepository extends JpaRepository<Room, Long>{
    // finding rooms by room number
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);

    // finding rooms by name
    List<Room> findByName(String name);

    // finding rooms by room number and bed info
    Optional<Room> findByRoomNumberAndBedInfo(String roomNumber, String bedInfo);
}
