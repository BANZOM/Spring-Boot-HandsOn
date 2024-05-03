package com.banzo.study.yolozeee;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.banzo.study.yolozeee.data.entity.Guest;
import com.banzo.study.yolozeee.data.entity.Reservation;
import com.banzo.study.yolozeee.data.entity.Room;
import com.banzo.study.yolozeee.data.repository.GuestRepository;
import com.banzo.study.yolozeee.data.repository.ReservationRepository;
import com.banzo.study.yolozeee.data.repository.RoomRepository;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Entity Room
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

        // Entity Guest
        List<Guest> guestsFindByState = guestRepository.findByState("CA");

        System.out.println("guests by state:");
        guestsFindByState.forEach(System.out::println);

        // Entity Reservation
        LocalDate reservationDate = LocalDate.parse("2023-08-28");
        List<Reservation> reservationsFindByReservationDate = reservationRepository.findByReservationDate(Date.valueOf("2023-08-28"));

        System.out.println("reservations by reservation date:");
        reservationsFindByReservationDate.forEach(System.out::println);
    }
    
}
