package com.correlation.maxim.presentation.presenter;

import com.correlation.maxim.domain.interactor.GetCorrelationOfTwoDatasetsUseCase;
import com.correlation.maxim.domain.logging.Logger;
import com.correlation.maxim.presentation.model.HealthValueNamePresentation;
import com.correlation.maxim.presentation.model.mappers.HealthValueNameMapper;
import com.correlation.maxim.presentation.view.TwoDatasetsView;

import javax.inject.Inject;

import rx.observers.Subscribers;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class TwoDatasetsPresenter extends BasePresenter<TwoDatasetsView> {
    private static final String TAG = TwoDatasetsPresenter.class.getSimpleName();
    private Logger logger;
    private HealthValueNameMapper healthValueNameMapper;
    private GetCorrelationOfTwoDatasetsUseCase getCorrelationOfTwoDatasetsUseCase;

    @Inject
    public TwoDatasetsPresenter(Logger logger, HealthValueNameMapper healthValueNameMapper, GetCorrelationOfTwoDatasetsUseCase getCorrelationOfTwoDatasetsUseCase) {
        this.logger = logger;
        this.healthValueNameMapper = healthValueNameMapper;
        this.getCorrelationOfTwoDatasetsUseCase = getCorrelationOfTwoDatasetsUseCase;
    }

    public void computeCorrelation(HealthValueNamePresentation firstDatasetName, HealthValueNamePresentation secondDatasetName) {
        execute(getCorrelationOfTwoDatasetsUseCase.build(healthValueNameMapper.map(firstDatasetName), healthValueNameMapper.map(secondDatasetName)),
                Subscribers.create(
                        this::onCorrelationComputed,
                        this::onComputingError
                )
        );
    }

    private void onCorrelationComputed(Double correlationValue) {
        getView().setCorrelationResult(correlationValue);
    }

    private void onComputingError(Throwable exception) {
        logger.error(TAG, exception.getMessage());
        getView().showError();
    }
}
