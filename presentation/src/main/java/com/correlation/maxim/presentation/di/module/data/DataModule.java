package com.correlation.maxim.presentation.di.module.data;

import com.correlation.maxim.presentation.di.scope.PerApplication;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 6/18/17.
 */

@Module
public class DataModule {
    @Provides
    @PerApplication
    Gson getGson() {
        return new Gson();
    }
}
