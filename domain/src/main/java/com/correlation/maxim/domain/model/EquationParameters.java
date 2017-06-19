package com.correlation.maxim.domain.model;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class EquationParameters {
    private double constant;
    private double slope;
    private double maxRange;
    private double minRange;

    public EquationParameters(double constant, double slope, double range, double minRange) {
        this.constant = constant;
        this.slope = slope;
        this.maxRange = range;
        this.minRange = minRange;
    }

    public double getConstant() {
        return constant;
    }

    public double getSlope() {
        return slope;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public double getMinRange() {
        return minRange;
    }

    public double computeEquationFor(double x){
        return constant + slope * x;
    }
}
