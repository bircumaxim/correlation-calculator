package com.correlation.maxim.domain.buissnes.regression;

import com.correlation.maxim.domain.model.DomainEntry;
import com.correlation.maxim.domain.model.EquationParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class CorrelationRegressionLineUtils {
    protected CorrelationRegressionLineUtils() {

    }

    public static List<DomainEntry> generateRegressionLineEntries(EquationParameters equationParameters) {
        List<DomainEntry> entries = new ArrayList<>();
        int delta = (int)equationParameters.getMaxRange() / 1100;
        for (int i = (int)equationParameters.getMinRange(); i <= (int) equationParameters.getMaxRange(); i = i + delta) {
            entries.add(new DomainEntry(i, equationParameters.computeEquationFor(i)));
        }
        return entries;
    }
}
