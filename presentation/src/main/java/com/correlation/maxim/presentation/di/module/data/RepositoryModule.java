package com.correlation.maxim.presentation.di.module.data;

import com.correlation.maxim.data.datasource.memory.Memory;
import com.correlation.maxim.data.datasource.memory.mappers.HealthDataMemoryMapper;
import com.correlation.maxim.data.datasource.storage.DeviceStorage;
import com.correlation.maxim.data.datasource.storage.mappers.HealthDataStorageMapper;
import com.correlation.maxim.data.repository.HealthDatasetsRepository;
import com.correlation.maxim.domain.gateway.HealthDatasetsGateWay;
import com.correlation.maxim.presentation.di.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 6/18/17.
 */

@Module
public class RepositoryModule {
    @Provides
    @PerApplication
    HealthDatasetsGateWay getHealthModelRepository(DeviceStorage deviceStorage,
                                                   Memory memory,
                                                   HealthDataStorageMapper healthModelStorageMapper,
                                                   HealthDataMemoryMapper healthModelMemoryMapper) {
        return new HealthDatasetsRepository(deviceStorage, memory, healthModelStorageMapper, healthModelMemoryMapper);
    }
}