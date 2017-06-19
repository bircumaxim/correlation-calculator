package com.correlation.maxim.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.correlation.maxim.domain.model.HealthModel;
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
        initRecyclerView();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.correlations_recycler_view);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        correlationMatrixAdapter = new CorrelationMatrixAdapter();
        recyclerView.setAdapter(correlationMatrixAdapter);
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

    @Override
    public void showLoading() {
        //TODO implement here loading
    }

    @Override
    public void showError() {
        //TODO notify user about error
    }

    @Override
    public void updateCorrelationMatrixList(List<HealthModel> modelsList) {
        correlationMatrixAdapter.setData(modelsList);
    }
}

