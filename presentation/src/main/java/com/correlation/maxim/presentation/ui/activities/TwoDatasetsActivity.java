package com.correlation.maxim.presentation.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.correlation.maxim.presentation.R;
import com.correlation.maxim.presentation.model.HealthValueNamePresentation;
import com.correlation.maxim.presentation.presenter.TwoDatasetsPresenter;
import com.correlation.maxim.presentation.view.TwoDatasetsView;

import org.w3c.dom.Text;

import javax.inject.Inject;


public class TwoDatasetsActivity extends BaseActivity<TwoDatasetsView, TwoDatasetsPresenter> implements TwoDatasetsView {

    private TextView correlationLabel;
    private Spinner firstDataSetName;
    private Spinner secondDataSetName;
    private Button computeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_datasets);
        getActivityComponent().inject(this);
        initViews();
        initSpinners();
    }

    @Inject
    @Override
    public void setPresenter(TwoDatasetsPresenter presenter) {
        super.setPresenter(presenter);
        presenter.bind(this);
    }

    private void initViews() {
        firstDataSetName = (Spinner) findViewById(R.id.first_dataset_name);
        secondDataSetName = (Spinner) findViewById(R.id.second_dataset_name);
        computeButton = (Button) findViewById(R.id.compute_correlation);
        correlationLabel = (TextView) findViewById(R.id.correlation_result_label);
        computeButton.setOnClickListener(this::computeCorrelation);
    }

    private void computeCorrelation(View view) {
        HealthValueNamePresentation firstDatasetName = HealthValueNamePresentation.getHealthValueByName(firstDataSetName.getSelectedItem().toString());
        HealthValueNamePresentation secondDatasetName = HealthValueNamePresentation.getHealthValueByName(secondDataSetName.getSelectedItem().toString());
        presenter.computeCorrelation(firstDatasetName, secondDatasetName);
    }

    private void initSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.health_dataset_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstDataSetName.setAdapter(adapter);
        secondDataSetName.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        //TODO implement here loading
    }

    @Override
    public void showError() {
        //TODO implement here error
    }

    @Override
    public void setCorrelationResult(Double correlationValue) {
        correlationLabel.setText(correlationValue.toString());
    }
}
