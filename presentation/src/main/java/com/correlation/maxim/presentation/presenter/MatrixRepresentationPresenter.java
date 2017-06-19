package com.correlation.maxim.presentation.presenter;

import com.correlation.maxim.domain.interactor.GetCorrelationMatrixDataUseCase;
import com.correlation.maxim.domain.model.HealthModel;
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
    private GetCorrelationMatrixDataUseCase getCorrelationMatrixDataUseCase;

    @Inject
    public MatrixRepresentationPresenter(Navigator navigator, GetCorrelationMatrixDataUseCase getCorrelationMatrixDataUseCase) {
        this.navigator = navigator;
        this.getCorrelationMatrixDataUseCase = getCorrelationMatrixDataUseCase;
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

    private void onMatrixDataLoaded(List<HealthModel> healthModelList) {
        getView().updateCorrelationMatrixList(healthModelList);
    }

    private void onError(Throwable throwable) {
        getView().showError();
    }
}