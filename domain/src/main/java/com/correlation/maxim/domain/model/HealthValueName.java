package com.correlation.maxim.domain.model;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public enum HealthValueName {
    YEAR,
    UPPER_CL,
    LOWER_CL,
    SAMPLE_CASE_W_CHARACTERISTIC,
    PERCENTAGE_W_CHARACTERISTIC,
    OVERALL_POPULATION_SIZE,
    OVERALL_SAMPLE_SIZE,
    EST_POP_CT_W_CHARACTERISTIC;

    public Double getHealthValueByName(HealthData healthModel){
        switch (this){
            case YEAR:
                return healthModel.getYear();
            case UPPER_CL:
                return healthModel.getUpperCl();
            case LOWER_CL:
                return healthModel.getLowerCl();
            case SAMPLE_CASE_W_CHARACTERISTIC:
                return healthModel.getSampleCasesWCharacteristic();
            case PERCENTAGE_W_CHARACTERISTIC:
                return healthModel.getPercentageWCharacteristic();
            case OVERALL_POPULATION_SIZE:
                return healthModel.getOverallPopulationSize();
            case OVERALL_SAMPLE_SIZE:
                return healthModel.getOverallSampleSize();
            case EST_POP_CT_W_CHARACTERISTIC:
                return healthModel.getEstPopCTwCharacteristic();
            default:
                return null;
        }
    }
}
