package com.correlation.maxim.data.datasource.storage.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by max on 6/18/17.
 */

public class HealthDataStorage {
    @SerializedName("est_pop_ct_w_characteristic")
    private double estPopCTwCharacteristic;

    @SerializedName("overall_sample_size")
    private double overallSampleSize;

    @SerializedName("overall_population_size")
    private double overallPopulationSize;

    @SerializedName("percentage_w_characteristic")
    private double percentageWCharacteristic;

    @SerializedName("sample_cases_w_characteristic")
    private double sampleCasesWCharacteristic;

    @SerializedName("lowercl")
    private double lowerCl;

    @SerializedName("uppercl")
    private double upperCl;

    @SerializedName("year")
    private double year;

    public double getEstPopCTwCharacteristic() {
        return estPopCTwCharacteristic;
    }

    public double getOverallSampleSize() {
        return overallSampleSize;
    }

    public double getOverallPopulationSize() {
        return overallPopulationSize;
    }

    public double getPercentageWCharacteristic() {
        return percentageWCharacteristic;
    }

    public double getSampleCasesWCharacteristic() {
        return sampleCasesWCharacteristic;
    }

    public double getLowerCl() {
        return lowerCl;
    }

    public double getUpperCl() {
        return upperCl;
    }

    public double getYear() {
        return year;
    }
}

