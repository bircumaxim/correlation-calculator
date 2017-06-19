package com.correlation.maxim.data.datasource.storage;

import android.content.Context;

import com.correlation.maxim.data.datasource.storage.model.HealthModelStorage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by max on 6/18/17.
 */

public class DeviceStorage {

    private Context context;
    private Gson gson;

    @Inject
    public DeviceStorage(Context context, Gson gson) {
        this.context = context;
        this.gson = gson;
    }

    public Observable<List<HealthModelStorage>> getHealthData() {
        Type collectionType = new TypeToken<List<HealthModelStorage>>() {
        }.getType();
        return Observable.just(gson.fromJson(JsonHelper.loadJSONFromAsset(context, "data.json"), collectionType));
    }
}
