package com.correlation.maxim.presentation;

import android.app.Application;

import com.correlation.maxim.presentation.di.componets.ApplicationComponent;
import com.correlation.maxim.presentation.di.componets.DaggerApplicationComponent;
import com.correlation.maxim.presentation.di.module.presentation.ApplicationModule;

/**
 * Created by max on 6/18/17.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
