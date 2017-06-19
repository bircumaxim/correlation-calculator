package com.correlation.maxim.presentation.di.qualifiers;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by max on 6/18/17.
 */

@Qualifier
@Retention(RUNTIME)
public @interface ActivityContext {
}
