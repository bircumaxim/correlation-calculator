package com.correlation.maxim.data.datasource.memory.mappers;

import com.correlation.maxim.data.datasource.memory.model.HealthDataMemory;
import com.correlation.maxim.domain.mappers.TwoWaysMapper;
import com.correlation.maxim.domain.model.HealthData;

import javax.inject.Inject;

/**
 * Created by max on 6/18/17.
 */

public class HealthDataMemoryMapper implements TwoWaysMapper<HealthDataMemory, HealthData> {
    @Inject
    public HealthDataMemoryMapper() {
    }

    @Override
    public HealthData map(HealthDataMemory healthModelMemory) {
        if (healthModelMemory == null)
            return null;

        HealthData healthModel = new HealthData();

        healthModel.setEstPopCTwCharacteristic(healthModelMemory.getEstPopCTwCharacteristic());
        healthModel.setOverallSampleSize(healthModelMemory.getOverallSampleSize());
        healthModel.setOverallPopulationSize(healthModelMemory.getOverallPopulationSize());
        healthModel.setPercentageWCharacteristic(healthModelMemory.getPercentageWCharacteristic());
        healthModel.setSampleCasesWCharacteristic(healthModelMemory.getSampleCasesWCharacteristic());
        healthModel.setLowerCl(healthModelMemory.getLowerCl());
        healthModel.setUpperCl(healthModelMemory.getUpperCl());
        healthModel.setYear(healthModelMemory.getYear());

        return healthModel;
    }

    @Override
    public HealthDataMemory inverseMap(HealthData healthModel) {
        if (healthModel == null)
            return null;

        HealthDataMemory healthModelMemory = new HealthDataMemory();

        healthModelMemory.setEstPopCTwCharacteristic(healthModel.getEstPopCTwCharacteristic());
        healthModelMemory.setOverallSampleSize(healthModel.getOverallSampleSize());
        healthModelMemory.setOverallPopulationSize(healthModel.getOverallPopulationSize());
        healthModelMemory.setPercentageWCharacteristic(healthModel.getPercentageWCharacteristic());
        healthModelMemory.setSampleCasesWCharacteristic(healthModel.getSampleCasesWCharacteristic());
        healthModelMemory.setLowerCl(healthModel.getLowerCl());
        healthModelMemory.setUpperCl(healthModel.getUpperCl());
        healthModelMemory.setYear(healthModel.getYear());

        return healthModelMemory;
    }
}
