package com.correlation.maxim.domain.model;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class HealthSingleValueData {
    private HealthValueName healthValueName;
    private double[] dataset;

    public HealthSingleValueData(HealthValueName healthValueName, double[] dataset) {
        this.healthValueName = healthValueName;
        this.dataset = dataset;
    }

    public HealthValueName getHealthValueName() {
        return healthValueName;
    }

    public double[] getDataset() {
        return dataset;
    }
}
