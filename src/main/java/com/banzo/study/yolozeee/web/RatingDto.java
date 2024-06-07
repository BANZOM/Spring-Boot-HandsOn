package com.banzo.study.yolozeee.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.banzo.study.yolozeee.domain.TourRating;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto {

    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    protected RatingDto() {
    }

    private RatingDto(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    public RatingDto(TourRating tourRating) {
        this(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
    }
}
