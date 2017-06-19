package com.correlation.maxim.presentation.presenter;

import com.correlation.maxim.domain.interactor.ComputeCorrelationLineEquationUseCase;
import com.correlation.maxim.domain.interactor.GetTwoDatasetsUseCase;
import com.correlation.maxim.domain.mappers.ListMapper;
import com.correlation.maxim.domain.model.DomainEntry;
import com.correlation.maxim.domain.model.TwoDatasets;
import com.correlation.maxim.presentation.chart.mappers.DomainEntryMapper;
import com.correlation.maxim.presentation.chart.mappers.EntryMapper;
import com.correlation.maxim.presentation.model.HealthValueNamePresentation;
import com.correlation.maxim.presentation.model.mappers.HealthValueNameMapper;
import com.correlation.maxim.presentation.view.ChartView;

import java.util.List;

import javax.inject.Inject;

import rx.observers.Subscribers;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class ChartPresenter extends BasePresenter<ChartView> {

    private DomainEntryMapper domainEntryMapper;
    private EntryMapper entryMapper;
    private HealthValueNameMapper healthValueNameMapper;
    private GetTwoDatasetsUseCase getTwoDatasetsUseCase;
    private ComputeCorrelationLineEquationUseCase getCorrelationLineUseCase;

    private TwoDatasets twoDatasets;

    @Inject
    public ChartPresenter(DomainEntryMapper domainEntryMapper, EntryMapper entryMapper,
                          HealthValueNameMapper healthValueNameMapper,
                          GetTwoDatasetsUseCase getTwoDatasetsUseCase,
                          ComputeCorrelationLineEquationUseCase getCorrelationLineUseCase) {
        this.domainEntryMapper = domainEntryMapper;
        this.entryMapper = entryMapper;
        this.healthValueNameMapper = healthValueNameMapper;
        this.getTwoDatasetsUseCase = getTwoDatasetsUseCase;
        this.getCorrelationLineUseCase = getCorrelationLineUseCase;
    }

    public void addDatasets(HealthValueNamePresentation firstDatasetName, HealthValueNamePresentation secondDatasetName) {
        execute(getTwoDatasetsUseCase.build(healthValueNameMapper.map(firstDatasetName), healthValueNameMapper.map(secondDatasetName)),
                Subscribers.create(
                        this::onDatasetsReceived,
                        this::onError
                )
        );
    }

    public void drawCorrelationLine(){
        if(twoDatasets == null){
            //TODO handle here exception
        } else {
            execute(getCorrelationLineUseCase.build(twoDatasets),
                    Subscribers.create(
                            this::onEquationLineComputed,
                            this::onError
                    )
            );
        }
    }

    private void onDatasetsReceived(TwoDatasets twoDatasets) {
        getView().addDatasets(entryMapper.map(twoDatasets));
    }

    private void onEquationLineComputed(List<DomainEntry> correlationDataset) {
        getView().addCorrelationLineDataSet(ListMapper.map(correlationDataset, domainEntryMapper::map));
    }

    private void onError(Throwable exception) {
        //TODO handle here exception
    }
}
