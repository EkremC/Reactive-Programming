package com.ekremc.chapter8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class _03_IOScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.io());

        source.subscribe(e -> ioOperation(e));
        source.subscribe(e -> ioOperation(e));
        source.subscribe(e -> ioOperation(e));
        source.subscribe(e -> ioOperation(e));
        source.subscribe(e -> ioOperation(e));
        source.subscribe(e -> ioOperation(e));
        source.subscribe(e -> ioOperation(e));
        source.subscribe(e -> ioOperation(e));
        source.subscribe(e -> ioOperation(e));

        Thread.sleep(50000);
    }

    public static void ioOperation(String e) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName() + " Value: " + e);
    }
}
