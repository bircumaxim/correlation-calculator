package com.correlation.maxim.presentation.view;

import com.github.mikephil.charting.data.Entry;

import java.util.List;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public interface ChartView extends BaseView {
    public void addDatasets(List<Entry> entries);
    public void addCorrelationLineDataSet(List<Entry> entries);
}
