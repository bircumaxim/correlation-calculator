package com.correlation.maxim.data.datasource.memory.model;

/**
 * Created by max on 6/18/17.
 */

public class HealthDataMemory {
    private double estPopCTwCharacteristic;
    private double overallSampleSize;
    private double overallPopulationSize;
    private double percentageWCharacteristic;
    private double sampleCasesWCharacteristic;
    private double lowerCl;
    private double upperCl;
    private double year;

    public double getEstPopCTwCharacteristic() {
        return estPopCTwCharacteristic;
    }

    public void setEstPopCTwCharacteristic(double estPopCTwCharacteristic) {
        this.estPopCTwCharacteristic = estPopCTwCharacteristic;
    }

    public double getOverallSampleSize() {
        return overallSampleSize;
    }

    public void setOverallSampleSize(double overallSampleSize) {
        this.overallSampleSize = overallSampleSize;
    }

    public double getOverallPopulationSize() {
        return overallPopulationSize;
    }

    public void setOverallPopulationSize(double overallPopulationSize) {
        this.overallPopulationSize = overallPopulationSize;
    }

    public double getPercentageWCharacteristic() {
        return percentageWCharacteristic;
    }

    public void setPercentageWCharacteristic(double percentageWCharacteristic) {
        this.percentageWCharacteristic = percentageWCharacteristic;
    }

    public double getSampleCasesWCharacteristic() {
        return sampleCasesWCharacteristic;
    }

    public void setSampleCasesWCharacteristic(double sampleCasesWCharacteristic) {
        this.sampleCasesWCharacteristic = sampleCasesWCharacteristic;
    }

    public double getLowerCl() {
        return lowerCl;
    }

    public void setLowerCl(double lowerCl) {
        this.lowerCl = lowerCl;
    }

    public double getUpperCl() {
        return upperCl;
    }

    public void setUpperCl(double upperCl) {
        this.upperCl = upperCl;
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }
}
