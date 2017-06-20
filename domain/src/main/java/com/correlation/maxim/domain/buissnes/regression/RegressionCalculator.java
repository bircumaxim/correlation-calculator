package com.correlation.maxim.domain.buissnes.regression;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class RegressionCalculator {
    private double xSum;
    private double ySum;
    private double xySum;
    private double x2Sum;
    private int sampleSize;
    private double maxRange;
    private double minRange;

    public RegressionCalculator(double[] xSample, double[] ySample) {
        this.xSum = computeSume(xSample);
        this.ySum = computeSume(ySample);
        this.xySum = computeXYsum(xSample, ySample);
        this.x2Sum = computeSquaredSum(xSample);
        this.sampleSize = xSample.length;
        this.maxRange = computeMaxRange(xSample);
        this.minRange = computeMinRange(xSample);
    }

    public double computeEquationConstant() {
        return (ySum * x2Sum - xSum * xySum) / (sampleSize * x2Sum - xSum * xSum);
    }


    public double computeEquationSlope() {
        return (sampleSize * xySum - xSum * ySum) / (sampleSize * x2Sum - xSum * xSum);
    }

    public double getMaxRange() {
        return this.maxRange;
    }

    private double computeMaxRange(double[] sample) {
        double maxValue = 0;
        for (double aSample : sample) {
            if (aSample > maxValue) {
                maxValue = aSample;
            }
        }
        return maxValue;
    }

    public double getMinRange() {
        return minRange;
    }

    private double computeMinRange(double[] sample) {
        double minValue = this.maxRange;
        for (double aSample : sample) {
            if (aSample < minValue) {
                minValue = aSample;
            }
        }
        return minValue;
    }

    private double computeSume(double[] sample) {
        double sum = 0;
        for (double aSample : sample) {
            sum += aSample;
        }
        return sum;
    }

    private double computeXYsum(double[] xSample, double[] ySample) {
        double sum = 0;
        for (int i = 0; i < xSample.length; i++) {
            sum += (xSample[i] * ySample[i]);
        }
        return sum;
    }

    private double computeSquaredSum(double[] sample) {
        double sum = 0;
        for (double aSample : sample) {
            sum += (aSample * aSample);
        }
        return sum;
    }
}
