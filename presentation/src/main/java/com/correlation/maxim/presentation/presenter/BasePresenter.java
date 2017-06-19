package com.correlation.maxim.presentation.presenter;

import com.correlation.maxim.domain.interactor.UseCase;

import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by max on 6/18/17.
 */
public abstract class BasePresenter<V> {
    private V view;
    private CompositeSubscription subscriptions;

    BasePresenter() {
        subscriptions = new CompositeSubscription();
    }

    public void resume() {
    }

    public void pause() {
    }

    public void destroy() {
        subscriptions.unsubscribe();
    }

    <T> void execute(UseCase<T> useCase, Subscriber<T> subscriber) {
        subscriptions.add(useCase.execute(subscriber));
    }

    <T> void execute(Single<T> observable, Subscriber<T> subscriber) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        subscriptions.add(subscription);
    }

    <T> void execute(Observable<T> observable, Subscriber<T> subscriber) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        subscriptions.add(subscription);
    }

    public V getView() {
        return view;
    }

    public void bind(V view) {
        this.view = view;
    }
}
