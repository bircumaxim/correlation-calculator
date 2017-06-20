package com.correlation.maxim.presentation.presenter;

import com.correlation.maxim.domain.interactor.GetCorrelationMatrixUseCase;
import com.correlation.maxim.domain.logging.Logger;
import com.correlation.maxim.domain.model.HealthData;
import com.correlation.maxim.presentation.view.MatrixRepresentationView;

import java.util.List;

import javax.inject.Inject;

import rx.observers.Subscribers;

/**
 * Created by max on 6/18/17.
 */

public class MatrixRepresentationPresenter extends BasePresenter<MatrixRepresentationView> {
    private static final String TAG = MatrixRepresentationPresenter.class.getSimpleName();
    private Logger logger;
    private GetCorrelationMatrixUseCase getCorrelationMatrixDataUseCase;

    @Inject
    MatrixRepresentationPresenter(Logger logger, GetCorrelationMatrixUseCase getCorrelationMatrixDataUseCase) {
        this.logger = logger;
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

    private void onMatrixDataLoaded(List<HealthData> healthModelList) {
        getView().updateCorrelationMatrixList(healthModelList);
    }

    private void onError(Throwable throwable) {
        logger.error(TAG, throwable.getMessage());
        getView().showError();
    }
}