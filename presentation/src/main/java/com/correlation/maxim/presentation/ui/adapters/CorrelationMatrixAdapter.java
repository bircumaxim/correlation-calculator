package com.correlation.maxim.presentation.ui.adapters;

import android.view.View;

import com.correlation.maxim.domain.model.HealthData;
import com.correlation.maxim.presentation.R;
import com.correlation.maxim.presentation.ui.viewholders.CorrelationMatrixViewHolder;

/**
 * Created by max on 6/18/17.
 */

public class CorrelationMatrixAdapter extends BaseAdapter<HealthData, CorrelationMatrixViewHolder> {

    public CorrelationMatrixAdapter() {
        super(R.layout.item_correlation_matrix);
    }

    @Override
    public CorrelationMatrixViewHolder onCreateViewHolder(View view) {
        return new CorrelationMatrixViewHolder(view);
    }

    @Override
    public void onBind(CorrelationMatrixViewHolder holder, HealthData model) {
        holder.setYearCorrelationLabel(model.getYear());
        holder.setOverAllSampleCorrelationLabel(model.getOverallSampleSize());
        holder.setOverAllSPopulatoinCorrelationLabel(model.getOverallPopulationSize());
        holder.setSampleCaseCorrelationLabel(model.getSampleCasesWCharacteristic());
        holder.setestPopulationCorrelationLabel(model.getEstPopCTwCharacteristic());
        holder.setPercentageCorrelationLabel(model.getPercentageWCharacteristic());
        holder.setLowerClCorrelationLabel(model.getLowerCl());
        holder.setUpperClCorrelationLabel(model.getUpperCl());
    }
}

