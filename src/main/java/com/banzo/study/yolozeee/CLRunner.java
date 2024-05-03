package com.banzo.study.yolozeee;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.banzo.study.yolozeee.data.entity.Room;
import com.banzo.study.yolozeee.data.repository.RoomRepository;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public CLRunner(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Room> allRooms = roomRepository.findAll();
        Optional<Room> rooms = roomRepository.findByRoomNumberIgnoreCase("p1");
        List<Room> roomsByName = roomRepository.findByName("Piccadilly");
        Optional<Room> roomsByRoomNumberAndBedInfo = roomRepository.findByRoomNumberAndBedInfo("P1", "1Q");

        System.out.println("all rooms:");
        allRooms.forEach(System.out::println);

        System.out.println("room by room number:");
        System.out.println(rooms);

        System.out.println("room by name:");
        roomsByName.forEach(System.out::println);

        System.out.println("room by room number and bed info:");
        System.out.println(roomsByRoomNumberAndBedInfo);
    }
    
}
