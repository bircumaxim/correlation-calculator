package com.correlation.maxim.presentation.chart.mappers;

import com.correlation.maxim.domain.mappers.Mapper;
import com.correlation.maxim.domain.model.DomainEntry;
import com.github.mikephil.charting.data.Entry;

import javax.inject.Inject;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class DomainEntryMapper implements Mapper<DomainEntry, Entry> {
    @Inject
    public DomainEntryMapper() {
    }

    @Override
    public Entry map(DomainEntry domainEntry) {
        if (domainEntry == null)
            return null;
        return new Entry((float) domainEntry.getX(), (float) domainEntry.getY());
    }
}
