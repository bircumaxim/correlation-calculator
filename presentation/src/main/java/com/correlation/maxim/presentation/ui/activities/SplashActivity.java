package com.correlation.maxim.presentation.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.correlation.maxim.presentation.presenter.SplashPresenter;
import com.correlation.maxim.presentation.view.SplashView;

import javax.inject.Inject;

/**
 * Created by max on 6/18/17.
 */

public class SplashActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
    }

    @Inject
    @Override
    public void setPresenter(SplashPresenter presenter) {
        super.setPresenter(presenter);
        presenter.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.openStartActivity();
    }

    @Override
    public void showLoading() {
        //TODO implement here loading.
    }

    @Override
    public void showError() {
        //TODO implement here error notification.
    }
}
