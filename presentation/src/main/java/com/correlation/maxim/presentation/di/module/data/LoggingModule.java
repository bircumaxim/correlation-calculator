package com.correlation.maxim.presentation.di.module.data;

import com.correlation.maxim.data.logging.LogCatLoggerAdapter;
import com.correlation.maxim.domain.logging.Logger;
import com.correlation.maxim.domain.logging.LoggerBuilder;
import com.correlation.maxim.presentation.di.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 6/20/17.
 */

@Module
public class LoggingModule {

    private final Logger logger;

    public LoggingModule() {
        logger = new LoggerBuilder()
                .appendNextLogger(new LogCatLoggerAdapter())
                .build();
    }

    @Provides
    @PerApplication
    public Logger getLogger() {
        return logger;
    }
}
