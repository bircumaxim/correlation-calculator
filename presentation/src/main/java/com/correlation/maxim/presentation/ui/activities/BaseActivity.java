package com.correlation.maxim.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.correlation.maxim.presentation.App;
import com.correlation.maxim.presentation.di.componets.ActivityComponent;
import com.correlation.maxim.presentation.di.componets.ApplicationComponent;
import com.correlation.maxim.presentation.di.componets.DaggerActivityComponent;
import com.correlation.maxim.presentation.di.module.presentation.ActivityModule;
import com.correlation.maxim.presentation.presenter.BasePresenter;
import com.correlation.maxim.presentation.view.BaseView;

import butterknife.ButterKnife;

/**
 * Created by max on 6/18/17.
 */

public abstract class BaseActivity<V extends BaseView, T extends BasePresenter<V>> extends AppCompatActivity {
    protected T presenter;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(getApplicationComponent())
                .build();
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.presenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.presenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.destroy();
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }

    protected ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
