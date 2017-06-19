package com.correlation.maxim.presentation.model.mappers;

import android.support.annotation.Nullable;

import com.correlation.maxim.domain.mappers.Mapper;
import com.correlation.maxim.domain.model.HealthValueName;
import com.correlation.maxim.presentation.model.HealthValueNamePresentation;

import javax.inject.Inject;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class HealthValueNameMapper implements Mapper<HealthValueNamePresentation, HealthValueName> {

    @Inject
    public HealthValueNameMapper() {
    }

    @Nullable
    @Override
    public HealthValueName map(HealthValueNamePresentation healthValueNamePresentation) {
        for (HealthValueName healthValueName : HealthValueName.values()) {
            if (healthValueName.toString().equals(healthValueNamePresentation.toString())) {
                return healthValueName;
            }
        }
        return null;
    }
}
