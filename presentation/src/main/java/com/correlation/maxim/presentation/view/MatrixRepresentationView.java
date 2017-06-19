package com.correlation.maxim.presentation.view;

import com.correlation.maxim.domain.model.HealthModel;

import java.util.List;

/**
 * Created by max on 6/18/17.
 */

public interface MatrixRepresentationView extends BaseView {
    public void updateCorrelationMatrixList(List<HealthModel> modelsList);
}