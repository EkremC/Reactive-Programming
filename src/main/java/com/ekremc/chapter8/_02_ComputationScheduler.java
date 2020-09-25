package com.ekremc.chapter8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

public class _02_ComputationScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation());


        source.subscribe(e -> compute(e));
        source.subscribe(e -> compute(e));
        source.subscribe(e -> compute(e));
        source.subscribe(e -> compute(e));
        source.subscribe(e -> compute(e));
        source.subscribe(e -> compute(e));
        source.subscribe(e -> compute(e));
        source.subscribe(e -> compute(e));
        source.subscribe(e -> compute(e));

        Thread.sleep(50000);
    }

    public static void compute(String e) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName() + " Value: " + e + " Time: " + LocalTime.now());
    }
}
