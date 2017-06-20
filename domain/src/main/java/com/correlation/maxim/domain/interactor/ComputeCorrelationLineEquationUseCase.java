package com.correlation.maxim.domain.interactor;

import com.correlation.maxim.domain.buissnes.regression.CorrelationRegressionLineUtils;
import com.correlation.maxim.domain.buissnes.regression.RegressionCalculator;
import com.correlation.maxim.domain.model.DomainEntry;
import com.correlation.maxim.domain.model.EquationParameters;
import com.correlation.maxim.domain.model.TwoDatasets;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class ComputeCorrelationLineEquationUseCase {

    @Inject
    ComputeCorrelationLineEquationUseCase() {
    }

    public Observable<List<DomainEntry>> build(TwoDatasets twoDatasets) {
        return Observable.defer(() -> {
            RegressionCalculator regressionCalculator = new RegressionCalculator(
                    twoDatasets.getFirstHealthSingleValueData().getDataset(),
                    twoDatasets.getSecondHealthSingleValueData().getDataset()
            );
            double constant = regressionCalculator.computeEquationConstant();
            double slope = regressionCalculator.computeEquationSlope();
            double maxRange = regressionCalculator.getMaxRange();
            double minRange = regressionCalculator.getMinRange();
            return Observable.just(CorrelationRegressionLineUtils.generateRegressionLineEntries(new EquationParameters(constant, slope, maxRange, minRange)));
        });
    }
}
