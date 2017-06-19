package com.correlation.maxim.domain.interactor;

import com.correlation.maxim.domain.buissnes.Correlation;
import com.correlation.maxim.domain.gateway.HealthDatasetsGateWay;
import com.correlation.maxim.domain.model.HealthValueName;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class GetCorrelationOfTwoDatasetsUseCase {

    private HealthDatasetsGateWay healthDatasetsGateWay;

    @Inject
    public GetCorrelationOfTwoDatasetsUseCase(HealthDatasetsGateWay healthDatasetsGateWay) {
        this.healthDatasetsGateWay = healthDatasetsGateWay;
    }

    public Observable<Double> build(HealthValueName firstDatasetName, HealthValueName secondDatasetName ) {
        return healthDatasetsGateWay.getTowSingleValueHealthDatasets(firstDatasetName, secondDatasetName)
                .map(twoDatasets -> Correlation.correlation(
                        twoDatasets.getFirstHealthSingleValueData(),
                        twoDatasets.getSecondHealthSingleValueData()
                ));
    }
}
