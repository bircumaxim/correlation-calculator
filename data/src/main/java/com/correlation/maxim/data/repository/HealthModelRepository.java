package com.correlation.maxim.data.repository;

import com.correlation.maxim.data.datasource.memory.Memory;
import com.correlation.maxim.data.datasource.memory.mappers.HealthModelMemoryMapper;
import com.correlation.maxim.data.datasource.storage.DeviceStorage;
import com.correlation.maxim.data.datasource.storage.mappers.HealthModelStorageMapper;
import com.correlation.maxim.domain.gateway.HealthModelGateWay;
import com.correlation.maxim.domain.mappers.ListMapper;
import com.correlation.maxim.domain.model.HealthModel;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by max on 6/18/17.
 */

public class HealthModelRepository implements HealthModelGateWay {

    private DeviceStorage deviceStorage;
    private Memory memory;
    private HealthModelStorageMapper healthModelStorageMapper;
    private HealthModelMemoryMapper healthModelMemoryMapper;

    @Inject
    public HealthModelRepository(DeviceStorage deviceStorage,
                                 Memory memory,
                                 HealthModelStorageMapper healthModelStorageMapper,
                                 HealthModelMemoryMapper healthModelMemoryMapper) {
        this.deviceStorage = deviceStorage;
        this.memory = memory;
        this.healthModelStorageMapper = healthModelStorageMapper;
        this.healthModelMemoryMapper = healthModelMemoryMapper;
    }

    @Override
    public Observable<List<HealthModel>> getHealthModelList() {
        return Observable.concat(getHealthModelsFromMemory(), getHealthModelsFromStorageAndPersist())
                .first(item -> item != null);
    }

    private Observable<List<HealthModel>> getHealthModelsFromMemory() {
        return memory.getHealthData()
                .map(item -> ListMapper.map(item, healthModelMemoryMapper::map));
    }

    private Observable<List<HealthModel>> getHealthModelsFromStorageAndPersist() {
        return deviceStorage.getHealthData()
                .map(item -> ListMapper.map(item, healthModelStorageMapper::map))
                .doOnNext(this::persistToMemory);
    }

    private void persistToMemory(List<HealthModel> healthModels) {
        memory.setHealthDataList(ListMapper.map(healthModels, healthModelMemoryMapper::inverseMap));
    }
}
