package com.ekremc.chapter8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class _04_NewThreadScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.newThread());

        source.subscribe(e -> task(e));

        Thread.sleep(5000);
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));

        Thread.sleep(50000);
    }

    public static void task(String e) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName() + " Value: " + e);
    }
}
