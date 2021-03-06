package com.correlation.maxim.domain.buissnes.correlation;

import com.correlation.maxim.domain.model.HealthData;

import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.List;

/**
 * Created by max on 6/18/17.
 */

public class HealthDatasetCorrelationMatrix extends CorrelationMatrix<HealthData> {
    private static final int MATRIX_DIMENSION = 8;

    @Override
    RealMatrix convertListToRealMatrix(List<HealthData> dataList) {
        RealMatrix matrix = new BlockRealMatrix(dataList.size(), MATRIX_DIMENSION);
        int i = 0;

        for (HealthData element : dataList) {
            matrix.setEntry(i, 0, element.getYear());
            matrix.setEntry(i, 1, element.getOverallSampleSize());
            matrix.setEntry(i, 2, element.getOverallPopulationSize());
            matrix.setEntry(i, 3, element.getSampleCasesWCharacteristic());
            matrix.setEntry(i, 4, element.getEstPopCTwCharacteristic());
            matrix.setEntry(i, 5, element.getPercentageWCharacteristic());
            matrix.setEntry(i, 6, element.getLowerCl());
            matrix.setEntry(i, 7, element.getUpperCl());
            i++;
        }
        return matrix;
    }

    @Override
    HealthData mapColumn(double[] column) {
        if (column.length < MATRIX_DIMENSION) {
            return null;
        }

        HealthData healthModel = new HealthData();

        healthModel.setYear(column[0]);
        healthModel.setOverallSampleSize(column[1]);
        healthModel.setOverallPopulationSize(column[2]);
        healthModel.setSampleCasesWCharacteristic(column[3]);
        healthModel.setEstPopCTwCharacteristic(column[4]);
        healthModel.setPercentageWCharacteristic(column[5]);
        healthModel.setLowerCl(column[6]);
        healthModel.setUpperCl(column[7]);

        return healthModel;
    }
}

