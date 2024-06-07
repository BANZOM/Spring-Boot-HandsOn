 package com.banzo.study.yolozeee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.banzo.study.yolozeee.domain.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer>{
    // PagingAndSortingRepository is a sub-interface of CrudRepository that provides additional methods to retrieve entities using pagination and sorting.
    // includes additional methods to retrieve entities using pagination and sorting like page, size, sort, desc, asc, etc.

    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);
}
