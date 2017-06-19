package com.correlation.maxim.presentation.chart.mappers;

import com.correlation.maxim.domain.mappers.Mapper;
import com.correlation.maxim.domain.model.HealthSingleValueData;
import com.correlation.maxim.domain.model.TwoDatasets;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class EntryMapper implements Mapper<TwoDatasets, List<Entry>> {

    @Inject
    public EntryMapper() {
    }

    @Override
    public List<Entry> map(TwoDatasets model) {
        List<Entry> entries = new ArrayList<>();
        HealthSingleValueData firstHealthSingleValueData = model.getFirstHealthSingleValueData();
        HealthSingleValueData secondHealthSingleValueData = model.getSecondHealthSingleValueData();

        for (int i = 0; i < firstHealthSingleValueData.getDataset().length; i++) {
            Entry entry = new Entry((float) firstHealthSingleValueData.getDataset()[i], (float) secondHealthSingleValueData.getDataset()[i]);
            entries.add(entry);
        }
        return entries;
    }
}
