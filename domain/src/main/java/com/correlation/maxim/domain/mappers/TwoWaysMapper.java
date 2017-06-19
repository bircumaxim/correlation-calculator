package com.correlation.maxim.domain.mappers;

/**
 * Created by max on 6/18/17.
 */
public interface TwoWaysMapper<M, P> extends Mapper<M, P> {
    M inverseMap(P model);
}