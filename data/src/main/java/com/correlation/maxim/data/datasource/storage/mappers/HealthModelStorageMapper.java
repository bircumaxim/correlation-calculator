package com.correlation.maxim.data.datasource.storage.mappers;

import com.correlation.maxim.data.datasource.storage.model.HealthModelStorage;
import com.correlation.maxim.domain.mappers.Mapper;
import com.correlation.maxim.domain.model.HealthModel;

import javax.inject.Inject;

/**
 * Created by max on 6/18/17.
 */

public class HealthModelStorageMapper implements Mapper<HealthModelStorage, HealthModel> {

    @Inject
    public HealthModelStorageMapper() {
    }

    @Override
    public HealthModel map(HealthModelStorage healthModelData) {
        if (healthModelData == null)
            return null;

        HealthModel healthModel = new HealthModel();

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
