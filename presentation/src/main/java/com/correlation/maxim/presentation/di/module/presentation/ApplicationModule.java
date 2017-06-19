package com.correlation.maxim.presentation.di.module.presentation;

import android.content.Context;

import com.correlation.maxim.presentation.di.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 6/18/17.
 */

@Module
public class ApplicationModule {
    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @PerApplication
    Context getApplicationContext() {
        return context;
    }
}

