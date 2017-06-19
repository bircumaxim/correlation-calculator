package com.correlation.maxim.presentation.ui.activities;

import android.os.Bundle;
import android.view.View;

import com.correlation.maxim.presentation.R;
import com.correlation.maxim.presentation.presenter.StartPresenter;
import com.correlation.maxim.presentation.view.StartView;

import javax.inject.Inject;

public class StartActivity extends BaseActivity<StartView, StartPresenter> implements StartView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getActivityComponent().inject(this);
        initViews();
    }

    @Inject
    @Override
    public void setPresenter(StartPresenter presenter) {
        super.setPresenter(presenter);
        presenter.bind(this);
    }

    private void initViews(){
        findViewById(R.id.correlation_matrix).setOnClickListener(this::onCorrelationMatrixClick);
        findViewById(R.id.specific_datasets).setOnClickListener(this::onSpecificDatasetClick);
        findViewById(R.id.chart_visualization).setOnClickListener(this::onChartVisializationClick);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }
    
    private void onSpecificDatasetClick(View view) {
        presenter.specificDataset();
    }

    private void onCorrelationMatrixClick(View view) {
        presenter.correlationMatrix();
    }

    private void onChartVisializationClick(View view) {
        presenter.chartVisualization();
    }
}
