package com.correlation.maxim.presentation.di.module.domain;

import com.correlation.maxim.domain.gateway.HealthDatasetsGateWay;
import com.correlation.maxim.domain.interactor.GetCorrelationMatrixUseCase;
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
    GetCorrelationMatrixUseCase getCorrelationMatrixDataUseCase(HealthDatasetsGateWay healthModelGateWay) {
        return new GetCorrelationMatrixUseCase(healthModelGateWay);
    }
}