package com.banzo.study.yolozeee.service;

import org.springframework.stereotype.Service;

import com.banzo.study.yolozeee.domain.TourPackage;
import com.banzo.study.yolozeee.repository.TourPackageRepository;

@Service
public class TourPackageService {

    private TourPackageRepository tourPackageRepository;

    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage creatTourPackage(String code, String name) {
        return tourPackageRepository.findById(code).orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    public Iterable<TourPackage> lookup() {
        return tourPackageRepository.findAll();
    }

    public long total() {
        return tourPackageRepository.count();
    }

}
