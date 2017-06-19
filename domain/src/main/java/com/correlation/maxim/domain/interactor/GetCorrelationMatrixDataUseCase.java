package com.correlation.maxim.domain.interactor;

import com.correlation.maxim.domain.buissnes.HealthDataCorrelation;
import com.correlation.maxim.domain.gateway.HealthModelGateWay;
import com.correlation.maxim.domain.model.HealthModel;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by max on 6/18/17.
 */

public class GetCorrelationMatrixDataUseCase extends UseCase<List<HealthModel>> {
    private HealthModelGateWay healthModelGateWay;
    private HealthDataCorrelation healthDataCorrelation;

    @Inject
    public GetCorrelationMatrixDataUseCase(HealthModelGateWay healthModelGateWay) {
        this.healthModelGateWay = healthModelGateWay;
        this.healthDataCorrelation = new HealthDataCorrelation();
    }

    @Override
    protected Observable<List<HealthModel>> buildUseCaseObservable() {
        return healthModelGateWay.getHealthModelList()
                .map(healthDataCorrelation::compute);
    }
}
