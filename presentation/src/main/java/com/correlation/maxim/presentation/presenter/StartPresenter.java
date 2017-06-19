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
    public StartPresenter(Navigator navigator) {
        this.navigator = navigator;
    }

    public void correlationMatrix(){
        navigator.openMatrixRepresentationActivity();
    }

    public void specificDataset() {
        navigator.openTwoDatasetsActivity();
    }
}