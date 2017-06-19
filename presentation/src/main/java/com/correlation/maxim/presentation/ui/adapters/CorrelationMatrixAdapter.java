package com.correlation.maxim.presentation.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.correlation.maxim.domain.model.HealthModel;
import com.correlation.maxim.presentation.R;
import com.correlation.maxim.presentation.ui.viewholders.CorrelationMatrixViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 6/18/17.
 */

public class CorrelationMatrixAdapter extends RecyclerView.Adapter<CorrelationMatrixViewHolder> {
    private List<HealthModel> data;

    public CorrelationMatrixAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public CorrelationMatrixViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_correlation_matrix, parent, false);
        return new CorrelationMatrixViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CorrelationMatrixViewHolder holder, int position) {
        HealthModel healthModel = data.get(position);
        holder.setYearCorrelationLabel(healthModel.getYear());
        holder.setOverAllSampleCorrelationLabel(healthModel.getOverallSampleSize());
        holder.setOverAllSPopulatoinCorrelationLabel(healthModel.getOverallPopulationSize());
        holder.setSampleCaseCorrelationLabel(healthModel.getSampleCasesWCharacteristic());
        holder.setestPopulationCorrelationLabel(healthModel.getEstPopCTwCharacteristic());
        holder.setPercentageCorrelationLabel(healthModel.getPercentageWCharacteristic());
        holder.setLowerClCorrelationLabel(healthModel.getLowerCl());
        holder.setUpperClCorrelationLabel(healthModel.getUpperCl());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public final void setData(List<HealthModel> models) {
        int itemCount = getItemCount();
        data.addAll(itemCount, models);
        notifyItemRangeInserted(itemCount, models.size());
    }
}

