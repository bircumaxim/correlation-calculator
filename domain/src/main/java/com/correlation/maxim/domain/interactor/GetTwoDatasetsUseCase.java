package com.correlation.maxim.domain.interactor;

import com.correlation.maxim.domain.gateway.HealthDatasetsGateWay;
import com.correlation.maxim.domain.model.HealthValueName;
import com.correlation.maxim.domain.model.TwoDatasets;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class GetTwoDatasetsUseCase {

    private HealthDatasetsGateWay healthDatasetsGateWay;

    @Inject
    GetTwoDatasetsUseCase(HealthDatasetsGateWay healthDatasetsGateWay) {
        this.healthDatasetsGateWay = healthDatasetsGateWay;
    }

    public Observable<TwoDatasets> build(HealthValueName firstDatasetName, HealthValueName secondDatasetName) {
        return healthDatasetsGateWay.getTowSingleValueHealthDatasets(firstDatasetName, secondDatasetName);
    }
}
