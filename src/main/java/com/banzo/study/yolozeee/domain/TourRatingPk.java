package com.banzo.study.yolozeee.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TourRatingPk {

    @ManyToOne
    private Tour tour;

    @Column(insertable = false, updatable = false, nullable = false)
    private Integer customerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourRatingPk that = (TourRatingPk) o;

        if (!tour.equals(that.tour)) return false;
        return customerId.equals(that.customerId);
    }

    @Override
    public int hashCode() {
        int result = tour.hashCode();
        result = 31 * result + customerId.hashCode();
        return result;
    }
}
