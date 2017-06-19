package com.correlation.maxim.domain.buissnes.correlation;

import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 6/18/17.
 */

public abstract class CorrelationMatrix<T> {

    public List<T> compute(List<T> list) {
        RealMatrix matrix = convertListToRealMatrix(list);
        RealMatrix outMatrix = computeCorrelationMatrix(matrix);

        return mpatToList(outMatrix);
    }

    private List<T> mpatToList(RealMatrix outMatrix) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            double[] column = outMatrix.getColumn(i);
            result.add(mapColumn(column));
        }
        return result;
    }

    private RealMatrix computeCorrelationMatrix(RealMatrix matrix) {
        int nVars = matrix.getColumnDimension();
        RealMatrix outMatrix = new BlockRealMatrix(nVars, nVars);
        for (int i = 0; i < nVars; i++) {
            for (int j = 0; j < i; j++) {

                double corr = Correlation.correlation(matrix.getColumn(i), matrix.getColumn(j));
                outMatrix.setEntry(i, j, corr);
                outMatrix.setEntry(j, i, corr);
            }
            outMatrix.setEntry(i, i, 1d);
        }
        return outMatrix;
    }

    abstract RealMatrix convertListToRealMatrix(List<T> dataList);

    abstract T mapColumn(double[] column);

}
