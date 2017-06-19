package com.correlation.maxim.presentation.navigation;

import android.app.Activity;
import android.content.Intent;

import com.correlation.maxim.presentation.di.qualifiers.ActivityContext;
import com.correlation.maxim.presentation.ui.activities.ChartActivity;
import com.correlation.maxim.presentation.ui.activities.MatrixRepresentationActivity;
import com.correlation.maxim.presentation.ui.activities.StartActivity;
import com.correlation.maxim.presentation.ui.activities.TwoDatasetsActivity;

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

    public void openTwoDatasetsActivity() {
        Intent intent = new Intent(activity, TwoDatasetsActivity.class);
        activity.startActivity(intent);
    }

    public void openMatrixRepresentationActivity() {
        openActivity(MatrixRepresentationActivity.class);
    }

    public void openStartActivity() {
        openActivity(StartActivity.class);
        activity.finish();
    }

    public void openChartActivity() {
        openActivity(ChartActivity.class);
    }

    private void openActivity(Class activityToOpen) {
        Intent intent = new Intent(activity, activityToOpen);
        activity.startActivity(intent);
    }
}

