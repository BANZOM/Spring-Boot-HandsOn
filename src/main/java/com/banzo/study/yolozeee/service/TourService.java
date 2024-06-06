package com.banzo.study.yolozeee.service;

import org.springframework.stereotype.Service;

import com.banzo.study.yolozeee.domain.Difficulty;
import com.banzo.study.yolozeee.domain.Region;
import com.banzo.study.yolozeee.domain.Tour;
import com.banzo.study.yolozeee.domain.TourPackage;
import com.banzo.study.yolozeee.repository.TourPackageRepository;
import com.banzo.study.yolozeee.repository.TourRepository;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region) {

        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(() -> new RuntimeException("Tour package does not exist: " + tourPackageName));

        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    public long total() {
        return tourRepository.count();
    }

}
