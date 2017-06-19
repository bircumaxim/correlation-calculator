package com.correlation.maxim.presentation.di.componets;

import com.correlation.maxim.presentation.di.module.domain.DomainModule;
import com.correlation.maxim.presentation.di.module.presentation.ActivityModule;
import com.correlation.maxim.presentation.di.scope.PerActivity;
import com.correlation.maxim.presentation.ui.activities.MatrixRepresentationActivity;

import dagger.Component;

/**
 * Created by max on 6/18/17.
 */
@PerActivity
@Component(
        modules = {
                ActivityModule.class,
                DomainModule.class
        },
        dependencies = {
                ApplicationComponent.class
        }
)
public interface ActivityComponent {
    void inject(MatrixRepresentationActivity activity);
}

