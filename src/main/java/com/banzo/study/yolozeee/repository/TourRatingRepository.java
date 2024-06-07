package com.banzo.study.yolozeee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banzo.study.yolozeee.domain.TourRating;
import com.banzo.study.yolozeee.domain.TourRatingPk;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk>{
    List<TourRating> findByPkTourId(Integer toudId);
    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}
