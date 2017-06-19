package com.correlation.maxim.presentation.presenter;

import com.correlation.maxim.domain.interactor.GetCorrelationOfTwoDatasetsUseCase;
import com.correlation.maxim.presentation.model.HealthValueNamePresentation;
import com.correlation.maxim.presentation.model.mappers.HealthValueNameMapper;
import com.correlation.maxim.presentation.navigation.Navigator;
import com.correlation.maxim.presentation.view.TwoDatasetsView;

import javax.inject.Inject;

import rx.observers.Subscribers;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class TwoDatasetsPresenter extends BasePresenter<TwoDatasetsView> {
    private Navigator navigator;
    private HealthValueNameMapper healthValueNameMapper;
    private GetCorrelationOfTwoDatasetsUseCase getCorrelationOfTwoDatasetsUseCase;

    @Inject
    public TwoDatasetsPresenter(Navigator navigator, HealthValueNameMapper healthValueNameMapper, GetCorrelationOfTwoDatasetsUseCase getCorrelationOfTwoDatasetsUseCase) {
        this.navigator = navigator;
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

    public void onCorrelationComputed(Double correlationValue) {
        getView().setCorrelationResult(correlationValue);
    }

    public void onComputingError(Throwable exception) {
        //TODO show here exception.
    }
}
