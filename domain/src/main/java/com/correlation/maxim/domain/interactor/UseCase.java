package com.correlation.maxim.domain.interactor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by max on 6/18/17.
 */

public abstract class UseCase<T> {
    protected abstract Observable<T> buildUseCaseObservable();

    public Subscription execute(Subscriber<T> subscriber) {
        return buildUseCaseObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
