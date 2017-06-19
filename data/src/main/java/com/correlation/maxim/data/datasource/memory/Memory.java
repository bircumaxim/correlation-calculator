package com.correlation.maxim.data.datasource.memory;

import com.correlation.maxim.data.datasource.memory.model.HealthDataMemory;

import java.util.List;

import rx.Observable;


/**
 * Created by max on 6/18/17.
 */

public class Memory {
    private List<HealthDataMemory> healthDataList;

    public Observable<List<HealthDataMemory>> getHealthData() {
        return Observable.just(healthDataList);
    }

    public void setHealthDataList(List<HealthDataMemory> healthDataList) {
        this.healthDataList = healthDataList;
    }
}
