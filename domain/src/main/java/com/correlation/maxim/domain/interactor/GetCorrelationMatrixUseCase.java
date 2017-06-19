package com.correlation.maxim.domain.interactor;

import com.correlation.maxim.domain.buissnes.correlation.HealthDatasetCorrelationMatrix;
import com.correlation.maxim.domain.gateway.HealthDatasetsGateWay;
import com.correlation.maxim.domain.model.HealthData;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by max on 6/18/17.
 */

public class GetCorrelationMatrixUseCase extends UseCase<List<HealthData>> {
    private HealthDatasetsGateWay healthModelGateWay;
    private HealthDatasetCorrelationMatrix healthDataCorrelation;

    @Inject
    public GetCorrelationMatrixUseCase(HealthDatasetsGateWay healthModelGateWay) {
        this.healthModelGateWay = healthModelGateWay;
        this.healthDataCorrelation = new HealthDatasetCorrelationMatrix();
    }

    @Override
    protected Observable<List<HealthData>> buildUseCaseObservable() {
        return healthModelGateWay.getHealthDataset()
                .map(healthDataCorrelation::compute);
    }
}
