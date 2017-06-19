package com.correlation.maxim.data.repository;

import android.support.annotation.NonNull;

import com.correlation.maxim.data.datasource.memory.Memory;
import com.correlation.maxim.data.datasource.memory.mappers.HealthDataMemoryMapper;
import com.correlation.maxim.data.datasource.storage.DeviceStorage;
import com.correlation.maxim.data.datasource.storage.mappers.HealthDataStorageMapper;
import com.correlation.maxim.domain.gateway.HealthDatasetsGateWay;
import com.correlation.maxim.domain.mappers.ListMapper;
import com.correlation.maxim.domain.model.HealthData;
import com.correlation.maxim.domain.model.HealthSingleValueData;
import com.correlation.maxim.domain.model.HealthValueName;
import com.correlation.maxim.domain.model.TwoDatasets;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by max on 6/18/17.
 */

public class HealthDatasetsRepository implements HealthDatasetsGateWay {

    private DeviceStorage deviceStorage;
    private Memory memory;
    private HealthDataStorageMapper healthModelStorageMapper;
    private HealthDataMemoryMapper healthModelMemoryMapper;

    @Inject
    public HealthDatasetsRepository(DeviceStorage deviceStorage,
                                    Memory memory,
                                    HealthDataStorageMapper healthModelStorageMapper,
                                    HealthDataMemoryMapper healthModelMemoryMapper) {
        this.deviceStorage = deviceStorage;
        this.memory = memory;
        this.healthModelStorageMapper = healthModelStorageMapper;
        this.healthModelMemoryMapper = healthModelMemoryMapper;
    }

    @Override
    public Observable<List<HealthData>> getHealthDataset() {
        return Observable.concat(getHealthModelsFromMemory(), getHealthModelsFromStorageAndPersist())
                .first(item -> item != null);
    }

    @Override
    public Observable<HealthSingleValueData> getSingleValueHealthDataset(HealthValueName healthValueName) {
        return getHealthDataset()
                .map(healthDataset -> getHealthSingleValueData(healthValueName, healthDataset));
    }


    @Override
    public Observable<TwoDatasets> getTowSingleValueHealthDatasets(HealthValueName firstDatasetName, HealthValueName secondDatasetName) {
        return getHealthDataset()
                .map(healthDataset -> new TwoDatasets(
                        getHealthSingleValueData(firstDatasetName, healthDataset),
                        getHealthSingleValueData(secondDatasetName, healthDataset)
                ));
    }

    private Observable<List<HealthData>> getHealthModelsFromMemory() {
        return memory.getHealthData()
                .map(item -> ListMapper.map(item, healthModelMemoryMapper::map));
    }

    private Observable<List<HealthData>> getHealthModelsFromStorageAndPersist() {
        return deviceStorage.getHealthData()
                .map(item -> ListMapper.map(item, healthModelStorageMapper::map))
                .doOnNext(this::persistToMemory);
    }

    private void persistToMemory(List<HealthData> healthModels) {
        memory.setHealthDataList(ListMapper.map(healthModels, healthModelMemoryMapper::inverseMap));
    }

    @NonNull
    private HealthSingleValueData getHealthSingleValueData(HealthValueName healthValueName, List<HealthData> healthDataset) {
        double[] singleValueHealthDataset = new double[healthDataset.size()];
        for (int i = 0; i < healthDataset.size(); i++) {
            singleValueHealthDataset[i] = healthValueName.getHealthValueByName(healthDataset.get(i));
        }
        return new HealthSingleValueData(healthValueName, singleValueHealthDataset);
    }
}
