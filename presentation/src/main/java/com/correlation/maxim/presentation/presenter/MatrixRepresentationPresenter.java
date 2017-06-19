package com.correlation.maxim.presentation.presenter;

import android.util.Log;

import com.correlation.maxim.domain.interactor.GetCorrelationMatrixUseCase;
import com.correlation.maxim.domain.interactor.GetCorrelationOfTwoDatasetsUseCase;
import com.correlation.maxim.domain.model.HealthData;
import com.correlation.maxim.domain.model.HealthValueName;
import com.correlation.maxim.presentation.navigation.Navigator;
import com.correlation.maxim.presentation.view.MatrixRepresentationView;

import java.util.List;

import javax.inject.Inject;

import rx.observers.Subscribers;

/**
 * Created by max on 6/18/17.
 */

public class MatrixRepresentationPresenter extends BasePresenter<MatrixRepresentationView> {
    private Navigator navigator;
    private GetCorrelationMatrixUseCase getCorrelationMatrixDataUseCase;
    private GetCorrelationOfTwoDatasetsUseCase getCorrelationOfTwoDatasetsUseCase;

    @Inject
    public MatrixRepresentationPresenter(Navigator navigator,
                                         GetCorrelationMatrixUseCase getCorrelationMatrixDataUseCase,
                                         GetCorrelationOfTwoDatasetsUseCase getCorrelationOfTwoDatasetsUseCase) {
        this.navigator = navigator;
        this.getCorrelationMatrixDataUseCase = getCorrelationMatrixDataUseCase;
        this.getCorrelationOfTwoDatasetsUseCase = getCorrelationOfTwoDatasetsUseCase;
    }

    public void loadCorrelationMatrixData() {
        getView().showLoading();
        execute(getCorrelationMatrixDataUseCase,
                Subscribers.create(
                        this::onMatrixDataLoaded,
                        this::onError
                )
        );
    }

    private void onMatrixDataLoaded(List<HealthData> healthModelList) {
        getView().updateCorrelationMatrixList(healthModelList);
    }

    private void onError(Throwable throwable) {
        getView().showError();
    }
}