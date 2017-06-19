package com.correlation.maxim.domain.buissnes.correlation;

import com.correlation.maxim.domain.model.HealthSingleValueData;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 * Created by max on 6/18/17.
 */

public class Correlation {
    private Correlation() {
    }

    public static double correlation(HealthSingleValueData xArray, HealthSingleValueData yArray) {
        return correlation(xArray.getDataset(), yArray.getDataset());
    }

    public static double correlation(final double[] xArray, final double[] yArray) {
        SimpleRegression regression = new SimpleRegression();
        if (xArray.length != yArray.length) {
            throw new DimensionMismatchException(xArray.length, yArray.length);
        } else if (xArray.length < 2) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION,
                    xArray.length, 2);
        } else {
            for (int i = 0; i < xArray.length; i++) {
                regression.addData(xArray[i], yArray[i]);
            }
            return regression.getR();
        }
    }
}
