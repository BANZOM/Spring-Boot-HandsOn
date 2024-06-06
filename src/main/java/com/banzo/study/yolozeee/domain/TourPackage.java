package com.banzo.study.yolozeee.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class TourPackage {

    @Id
    private String code;

    @Column
    private String name;

    protected TourPackage() {
    }

}
