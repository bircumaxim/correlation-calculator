package com.correlation.maxim.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.correlation.maxim.domain.model.HealthData;
import com.correlation.maxim.presentation.R;
import com.correlation.maxim.presentation.presenter.MatrixRepresentationPresenter;
import com.correlation.maxim.presentation.ui.adapters.CorrelationMatrixAdapter;
import com.correlation.maxim.presentation.view.MatrixRepresentationView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by max on 6/18/17.
 */

public class MatrixRepresentationActivity extends BaseActivity<MatrixRepresentationView, MatrixRepresentationPresenter> implements MatrixRepresentationView {

    protected RecyclerView recyclerView;
    private CorrelationMatrixAdapter correlationMatrixAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_representation);
        getActivityComponent().inject(this);
        initViews();
        setupRecyclerView();
    }

    @Inject
    @Override
    public void setPresenter(MatrixRepresentationPresenter presenter) {
        super.setPresenter(presenter);
        presenter.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadCorrelationMatrixData();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.correlations_recycler_view);

    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        correlationMatrixAdapter = new CorrelationMatrixAdapter();
        correlationMatrixAdapter.getOnClickObservable().subscribe(this::onCellSelected);
        recyclerView.setAdapter(correlationMatrixAdapter);
    }

    public void onCellSelected(HealthData healthModel) {
        //TODO handle here clicks.
    }

    @Override
    public void showLoading() {
        //TODO implement here loading.
    }

    @Override
    public void showError() {
        //TODO implement here error notification.
    }

    @Override
    public void updateCorrelationMatrixList(List<HealthData> modelsList) {
        correlationMatrixAdapter.addAll(modelsList);
    }
}

