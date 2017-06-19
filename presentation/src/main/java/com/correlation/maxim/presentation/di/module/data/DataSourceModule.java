package com.correlation.maxim.presentation.di.module.data;

import com.correlation.maxim.data.datasource.memory.Memory;
import com.correlation.maxim.presentation.di.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 6/18/17.
 */
@Module
public class DataSourceModule {
    @Provides
    @PerApplication
    public Memory getMemory() {
        return new Memory();
    }
}
