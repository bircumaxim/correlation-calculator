package com.correlation.maxim.presentation.presenter;

import com.correlation.maxim.presentation.navigation.Navigator;
import com.correlation.maxim.presentation.view.SplashView;

import javax.inject.Inject;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class SplashPresenter extends BasePresenter<SplashView> {

    private Navigator navigator;

    @Inject
    public SplashPresenter(Navigator navigator) {
        this.navigator = navigator;
    }

    public void openStartActivity() {
        navigator.openStartActivity();
    }
}
