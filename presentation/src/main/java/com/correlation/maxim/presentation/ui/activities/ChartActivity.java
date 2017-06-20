package com.correlation.maxim.presentation.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.correlation.maxim.presentation.R;
import com.correlation.maxim.presentation.chart.ChartController;
import com.correlation.maxim.presentation.model.HealthValueNamePresentation;
import com.correlation.maxim.presentation.presenter.ChartPresenter;
import com.correlation.maxim.presentation.view.ChartView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.List;

import javax.inject.Inject;

public class ChartActivity extends BaseActivity<ChartView, ChartPresenter> implements ChartView {
    private ChartController chartController;

    private LineChart lineChart;
    private Spinner firstDataSetName;
    private Spinner secondDataSetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        getActivityComponent().inject(this);
        initViews();
        initSpinners();

        chartController = new ChartController(lineChart);
    }

    @Inject
    @Override
    public void setPresenter(ChartPresenter presenter) {
        super.setPresenter(presenter);
        presenter.bind(this);
    }

    private void initViews() {
        firstDataSetName = (Spinner) findViewById(R.id.first_dataset_name);
        secondDataSetName = (Spinner) findViewById(R.id.second_dataset_name);
        findViewById(R.id.draw_chart).setOnClickListener(this::onDrawClick);
        findViewById(R.id.draw_correlation_line).setOnClickListener(this::onDrawCorrelationLine);
        lineChart = (LineChart) findViewById(R.id.line_chart);
    }

    private void initSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.health_dataset_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstDataSetName.setAdapter(adapter);
        secondDataSetName.setAdapter(adapter);
    }

    public void onDrawClick(View view) {
        HealthValueNamePresentation firstDatasetName = HealthValueNamePresentation.getHealthValueByName(firstDataSetName.getSelectedItem().toString());
        HealthValueNamePresentation secondDatasetName = HealthValueNamePresentation.getHealthValueByName(secondDataSetName.getSelectedItem().toString());
        presenter.addDatasets(firstDatasetName, secondDatasetName);
    }

    public void onDrawCorrelationLine(View view) {
        presenter.drawCorrelationLine();
    }

    @Override
    public void addDatasets(List<Entry> entries) {
        chartController.resetChart();
        chartController.drawValuesPoints(entries, "Dataset");
    }

    @Override
    public void addCorrelationLineDataSet(List<Entry> entries) {
        chartController.drawCorrelationLine(entries, "Correlation");
    }

    @Override
    public void showLoading() {
        //TODO implement loading here.
    }

    @Override
    public void showError() {
        //TODO show here error notification.
    }


}
