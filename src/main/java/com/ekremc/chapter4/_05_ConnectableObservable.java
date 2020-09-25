package com.ekremc.chapter4;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class _05_ConnectableObservable {

    public static void main(String[] args) throws InterruptedException {
        ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
        source.connect();

        source.subscribe(System.out::println);

        Thread.sleep(5000);

        source.subscribe(System.out::println);

        Thread.sleep(5000);

        source.subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
