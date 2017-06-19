package com.correlation.maxim.presentation.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.correlation.maxim.presentation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by max on 6/18/17.
 */

public class CorrelationMatrixViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.year_correlation)
    protected TextView yearCorrelationLabel;

    @BindView(R.id.overAllSample_correlation)
    protected TextView overAllSampleCorrelationLabel;

    @BindView(R.id.overAllSPopulatoin_correlation)
    protected TextView overAllSPopulatoinCorrelationLabel;

    @BindView(R.id.sampleCase_correlation)
    protected TextView sampleCaseCorrelationLabel;

    @BindView(R.id.estPopulation_correlation)
    protected TextView estPopulationCorrelationLabel;

    @BindView(R.id.percentage_correlation)
    protected TextView percentageCorrelationLabel;

    @BindView(R.id.lowerCl_correlation)
    protected TextView lowerClCorrelationLabel;

    @BindView(R.id.upperCl_correlation)
    protected TextView upperClCorrelationLabel;


    public CorrelationMatrixViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setYearCorrelationLabel(double yearCorrelationValue) {
        yearCorrelationLabel.setText(String.valueOf(yearCorrelationValue));
    }

    public void setOverAllSampleCorrelationLabel(double overAllSampleCorrelationValue) {
        overAllSampleCorrelationLabel.setText(String.valueOf(overAllSampleCorrelationValue));
    }

    public void setOverAllSPopulatoinCorrelationLabel(double overAllSPopulatoinCorrelationValue) {
        overAllSPopulatoinCorrelationLabel.setText(String.valueOf(overAllSPopulatoinCorrelationValue));
    }

    public void setSampleCaseCorrelationLabel(double sampleCaseCorrelationValue) {
        sampleCaseCorrelationLabel.setText(String.valueOf(sampleCaseCorrelationValue));
    }

    public void setestPopulationCorrelationLabel(double estPopulationCorrelationValue) {
        estPopulationCorrelationLabel.setText(String.valueOf(estPopulationCorrelationValue));
    }

    public void setPercentageCorrelationLabel(double percentageCorrelationValue) {
        percentageCorrelationLabel.setText(String.valueOf(percentageCorrelationValue));
    }

    public void setLowerClCorrelationLabel(double lowerClCorrelationValue) {
        lowerClCorrelationLabel.setText(String.valueOf(lowerClCorrelationValue));
    }

    public void setUpperClCorrelationLabel(double upperClCorrelationValue) {
        upperClCorrelationLabel.setText(String.valueOf(upperClCorrelationValue));
    }
}

