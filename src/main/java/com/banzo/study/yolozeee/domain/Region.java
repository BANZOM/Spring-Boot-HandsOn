package com.banzo.study.yolozeee.domain;

public enum Region {

    CENTRAL_COAST("Central Coast"),
    SOUTHERN_CALIFORNIA("Southern California"),
    NORTHERN_CALIFORNIA("Northern California"),
    VARIES("Varies");

    private String label;

    Region(String label) {
        this.label = label;
    }

    public static Region findByLabel(String byLabel) {
        for (Region r : Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return label;
    }

}
