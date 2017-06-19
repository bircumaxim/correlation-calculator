package com.correlation.maxim.presentation.chart;

import android.graphics.Color;

import com.correlation.maxim.domain.portability.BiConsumer;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.VISIBLE;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class ChartController {
    private LineChart chart;
    private ArrayList<ILineDataSet> dataSets;

    public ChartController(LineChart lineChart) {
        this.chart = lineChart;
        setChartStyle();
        dataSets = new ArrayList<>();
    }

    public void drawCorrelationLine(List<Entry> dataset, String label) {
        addDataSet(dataset, label, Color.BLACK, this::setCorrelationLineDataSetStyle);
    }

    public void drawValuesPoints(List<Entry> firstDataSet, String label) {
        addDataSet(firstDataSet, label, Color.GREEN, this::setDataSetStyle);
    }

    public void resetChart(){
        dataSets = new ArrayList<>();
    }

    private void addDataSet(List<Entry> dataset, String label, int dataSetColor, BiConsumer<LineDataSet, Integer> styleFunction) {
        LineDataSet lineDataSet = new LineDataSet(dataset, label);
        styleFunction.accept(lineDataSet, dataSetColor);
        dataSets.add(lineDataSet);
        LineData data = new LineData(dataSets);
        chart.setData(data);
        chart.invalidate();
        chart.setVisibility(VISIBLE);
        chart.highlightValue(50000, 3.0f, 0);
    }

    private void setChartStyle() {
        chart.getLegend().setEnabled(false);
        chart.setMinOffset(28);
        chart.setPinchZoom(true);
        chart.setMaxHighlightDistance(100);
    }

    private void setCorrelationLineDataSetStyle(LineDataSet dataSet, Integer color) {
        dataSet.setDrawCircles(false);
        dataSet.setLineWidth(1f);
        dataSet.setDrawValues(false);
        dataSet.setHighlightEnabled(true);
        dataSet.setDrawHighlightIndicators(false);
    }

    private void setDataSetStyle(LineDataSet dataSet, int color) {
        dataSet.setCircleColor(color);
        dataSet.setCircleHoleRadius(20f);
        dataSet.setDrawCircles(true);
        dataSet.setLineWidth(0f);
        dataSet.setDrawValues(false);
        dataSet.setHighlightEnabled(true);
        dataSet.setDrawHighlightIndicators(false);
    }
}
