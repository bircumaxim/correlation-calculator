package com.correlation.maxim.presentation.presenter;

import com.correlation.maxim.presentation.navigation.Navigator;
import com.correlation.maxim.presentation.view.StartView;

import javax.inject.Inject;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class StartPresenter extends BasePresenter<StartView> {

    private Navigator navigator;

    @Inject
    StartPresenter(Navigator navigator) {
        this.navigator = navigator;
    }

    public void correlationMatrix(){
        navigator.openMatrixRepresentationActivity();
    }

    public void specificDataset() {
        navigator.openTwoDatasetsActivity();
    }

    public void chartVisualization(){
        navigator.openChartActivity();
    }
}
