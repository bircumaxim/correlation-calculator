package com.correlation.maxim.presentation.di.module.data;

import com.correlation.maxim.data.datasource.memory.Memory;
import com.correlation.maxim.data.datasource.memory.mappers.HealthModelMemoryMapper;
import com.correlation.maxim.data.datasource.storage.DeviceStorage;
import com.correlation.maxim.data.datasource.storage.mappers.HealthModelStorageMapper;
import com.correlation.maxim.data.repository.HealthModelRepository;
import com.correlation.maxim.domain.gateway.HealthModelGateWay;
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
    HealthModelGateWay getHealthModelRepository(DeviceStorage deviceStorage,
                                                Memory memory,
                                                HealthModelStorageMapper healthModelStorageMapper,
                                                HealthModelMemoryMapper healthModelMemoryMapper) {
        return new HealthModelRepository(deviceStorage, memory, healthModelStorageMapper, healthModelMemoryMapper);
    }
}