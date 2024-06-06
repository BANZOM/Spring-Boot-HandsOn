package com.banzo.study.yolozeee.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Tour {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String blurb;

    @Column
    private Integer price;

    @Column
    private String duration;

    @Column(length = 2000)
    private String bullets;

    @Column
    private String keywords;

    @ManyToOne
    private TourPackage tourPackage;

    @Column
    @Enumerated
    private Difficulty difficulty;

    // so only fully initialized Tours can be created
    protected Tour() {
    }

}
