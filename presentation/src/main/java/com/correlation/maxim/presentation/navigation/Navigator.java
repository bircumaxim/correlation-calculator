package com.correlation.maxim.presentation.navigation;

import android.app.Activity;

import com.correlation.maxim.presentation.di.qualifiers.ActivityContext;

import javax.inject.Inject;

/**
 * Created by max on 6/18/17.
 */

public class Navigator {

    private Activity activity;

    @Inject
    Navigator(@ActivityContext Activity activity) {
        this.activity = activity;
    }
}

