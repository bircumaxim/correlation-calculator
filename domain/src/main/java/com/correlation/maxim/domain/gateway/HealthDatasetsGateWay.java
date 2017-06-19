package com.correlation.maxim.domain.gateway;

import com.correlation.maxim.domain.model.HealthData;
import com.correlation.maxim.domain.model.HealthSingleValueData;
import com.correlation.maxim.domain.model.HealthValueName;
import com.correlation.maxim.domain.model.TwoDatasets;

import java.util.List;

import rx.Observable;

/**
 * Created by max on 6/18/17.
 */

public interface HealthDatasetsGateWay {
    Observable<List<HealthData>> getHealthDataset();
    Observable<HealthSingleValueData> getSingleValueHealthDataset(HealthValueName healthValueName);
    Observable<TwoDatasets> getTowSingleValueHealthDatasets(HealthValueName firstDatasetName, HealthValueName secondDatasetName);
}

