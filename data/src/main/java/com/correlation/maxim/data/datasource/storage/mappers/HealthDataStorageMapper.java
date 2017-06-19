package com.correlation.maxim.data.datasource.storage.mappers;

import com.correlation.maxim.data.datasource.storage.model.HealthDataStorage;
import com.correlation.maxim.domain.mappers.Mapper;
import com.correlation.maxim.domain.model.HealthData;

import javax.inject.Inject;

/**
 * Created by max on 6/18/17.
 */

public class HealthDataStorageMapper implements Mapper<HealthDataStorage, HealthData> {

    @Inject
    public HealthDataStorageMapper() {
    }

    @Override
    public HealthData map(HealthDataStorage healthModelData) {
        if (healthModelData == null)
            return null;

        HealthData healthModel = new HealthData();

        healthModel.setEstPopCTwCharacteristic(healthModelData.getEstPopCTwCharacteristic());
        healthModel.setOverallSampleSize(healthModelData.getOverallSampleSize());
        healthModel.setOverallPopulationSize(healthModelData.getOverallPopulationSize());
        healthModel.setPercentageWCharacteristic(healthModelData.getPercentageWCharacteristic());
        healthModel.setSampleCasesWCharacteristic(healthModelData.getSampleCasesWCharacteristic());
        healthModel.setLowerCl(healthModelData.getLowerCl());
        healthModel.setUpperCl(healthModelData.getUpperCl());
        healthModel.setYear(healthModelData.getYear());

        return healthModel;
    }
}
