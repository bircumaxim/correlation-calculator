package com.correlation.maxim.presentation.di.module.presentation;

import android.app.Activity;

import com.correlation.maxim.presentation.di.qualifiers.ActivityContext;
import com.correlation.maxim.presentation.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 6/18/17.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Activity getActivityContext() {
        return activity;
    }
}
