package com.banzo.study.yolozeee.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.banzo.study.yolozeee.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String>{

    Optional<TourPackage> findByName(String name);
}
