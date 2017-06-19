package com.correlation.maxim.domain.mappers;

/**
 * Created by max on 6/18/17.
 */
@FunctionalInterface
public interface Mapper<M, P> {
    P map(M model);
}
