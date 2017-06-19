package com.correlation.maxim.data.datasource.memory.mappers;

import com.correlation.maxim.data.datasource.memory.model.HealthModelMemory;
import com.correlation.maxim.domain.mappers.Mapper;
import com.correlation.maxim.domain.mappers.TwoWaysMapper;
import com.correlation.maxim.domain.model.HealthModel;

import javax.inject.Inject;

/**
 * Created by max on 6/18/17.
 */

public class HealthModelMemoryMapper implements TwoWaysMapper<HealthModelMemory, HealthModel> {
    @Inject
    public HealthModelMemoryMapper() {
    }

    @Override
    public HealthModel map(HealthModelMemory healthModelMemory) {
        if (healthModelMemory == null)
            return null;

        HealthModel healthModel = new HealthModel();

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
    public HealthModelMemory inverseMap(HealthModel healthModel) {
        if (healthModel == null)
            return null;

        HealthModelMemory healthModelMemory = new HealthModelMemory();

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
