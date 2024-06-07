 package com.banzo.study.yolozeee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.banzo.study.yolozeee.domain.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer>{
    List<Tour> findByTourPackageCode(String code);
}
