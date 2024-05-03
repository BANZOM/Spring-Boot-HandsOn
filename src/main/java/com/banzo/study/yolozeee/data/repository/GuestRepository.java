package com.banzo.study.yolozeee.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banzo.study.yolozeee.data.entity.Guest;
import java.util.List;


public interface GuestRepository extends JpaRepository<Guest, Long>{

    List<Guest> findByState(String state);

}
