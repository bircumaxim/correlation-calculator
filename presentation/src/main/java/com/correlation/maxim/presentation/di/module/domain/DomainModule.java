package com.correlation.maxim.presentation.di.module.domain;

import com.correlation.maxim.domain.gateway.HealthModelGateWay;
import com.correlation.maxim.domain.interactor.GetCorrelationMatrixDataUseCase;
import com.correlation.maxim.presentation.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 6/18/17.
 */

@Module
public class DomainModule {
    @Provides
    @PerActivity
    GetCorrelationMatrixDataUseCase getCorrelationMatrixDataUseCase(HealthModelGateWay healthModelGateWay) {
        return new GetCorrelationMatrixDataUseCase(healthModelGateWay);
    }
}