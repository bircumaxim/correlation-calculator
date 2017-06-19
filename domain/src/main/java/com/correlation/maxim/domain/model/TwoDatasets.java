package com.correlation.maxim.domain.model;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class TwoDatasets {
    private HealthSingleValueData firstHealthSingleValueData;
    private HealthSingleValueData secondHealthSingleValueData;

    public TwoDatasets(HealthSingleValueData firstHealthSingleValueData, HealthSingleValueData secondHealthSingleValueData) {
        this.firstHealthSingleValueData = firstHealthSingleValueData;
        this.secondHealthSingleValueData = secondHealthSingleValueData;
    }

    public HealthSingleValueData getFirstHealthSingleValueData() {
        return firstHealthSingleValueData;
    }

    public HealthSingleValueData getSecondHealthSingleValueData() {
        return secondHealthSingleValueData;
    }
}
