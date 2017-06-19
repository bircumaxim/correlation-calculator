package com.correlation.maxim.domain.portability;

/**
 * Created by Maxim Bircu on 6/19/17.
 */
@FunctionalInterface
public interface BiConsumer<T,U> {
    void accept(T t,U u);
}
