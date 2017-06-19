package com.correlation.maxim.presentation.model;

import android.support.annotation.Nullable;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public enum HealthValueNamePresentation {
    YEAR("year"),
    UPPER_CL("upper_cl"),
    LOWER_CL("lower_cl"),
    SAMPLE_CASE_W_CHARACTERISTIC("sample_case_w_characteristic"),
    PERCENTAGE_W_CHARACTERISTIC("percentage_w_characteristic"),
    OVERALL_POPULATION_SIZE("overall_population_size"),
    OVERALL_SAMPLE_SIZE("overall_sample_size"),
    EST_POP_CT_W_CHARACTERISTIC("est_pop_ct_w_characteristic");

    private String healthValueName;

    HealthValueNamePresentation(String healthValueName) {
        this.healthValueName = healthValueName;
    }

    @Nullable
    public static HealthValueNamePresentation getHealthValueByName(String healthValueName) {
        for (HealthValueNamePresentation healthValueNamePresentation : values()) {
            if (healthValueNamePresentation.healthValueName.equals(healthValueName))
                return healthValueNamePresentation;
        }
        return null;
    }
}
