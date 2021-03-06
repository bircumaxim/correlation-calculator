package com.correlation.maxim.presentation.di.componets;

import com.correlation.maxim.domain.gateway.HealthDatasetsGateWay;
import com.correlation.maxim.domain.logging.Logger;
import com.correlation.maxim.presentation.di.module.data.DataModule;
import com.correlation.maxim.presentation.di.module.data.DataSourceModule;
import com.correlation.maxim.presentation.di.module.data.LoggingModule;
import com.correlation.maxim.presentation.di.module.data.RepositoryModule;
import com.correlation.maxim.presentation.di.module.presentation.ApplicationModule;
import com.correlation.maxim.presentation.di.scope.PerApplication;

import dagger.Component;

/**
 * Created by max on 6/18/17.
 */

@PerApplication
@Component(
        modules = {
                ApplicationModule.class,
                RepositoryModule.class,
                DataModule.class,
                DataSourceModule.class,
                LoggingModule.class
        }
)
public interface ApplicationComponent {
    HealthDatasetsGateWay getHealthModelGateWay();
    Logger getLogger();
}
