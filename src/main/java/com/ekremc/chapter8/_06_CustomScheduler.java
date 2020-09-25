package com.ekremc.chapter8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _06_CustomScheduler {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Scheduler scheduler = Schedulers.from(executorService);

        Observable<String> source = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(scheduler)
                .doFinally(executorService::shutdown);

        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
        source.subscribe(e -> task(e));
    }

    public static void task(String e) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName() + " Value: " + e);
    }
}
