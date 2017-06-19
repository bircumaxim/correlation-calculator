package com.correlation.maxim.data.datasource.memory;

import com.correlation.maxim.data.datasource.memory.model.HealthModelMemory;

import java.util.List;

import rx.Observable;


/**
 * Created by max on 6/18/17.
 */

public class Memory {
    private List<HealthModelMemory> healthDataList;

    public Observable<List<HealthModelMemory>> getHealthData() {
        return Observable.just(healthDataList);
    }

    public void setHealthDataList(List<HealthModelMemory> healthDataList) {
        this.healthDataList = healthDataList;
    }
}
