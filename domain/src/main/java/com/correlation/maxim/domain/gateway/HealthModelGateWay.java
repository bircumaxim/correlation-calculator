package com.correlation.maxim.domain.gateway;

import com.correlation.maxim.domain.model.HealthModel;

import java.util.List;

import rx.Observable;

/**
 * Created by max on 6/18/17.
 */

public interface HealthModelGateWay {
    Observable<List<HealthModel>> getHealthModelList();
}

