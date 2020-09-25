package com.ekremc.chapter6;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class _01_MergeAndConcat {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source1 = Observable.just("Ella", "Alexa", "Lily");
        Observable<String> source2 = Observable.just("Priya", "Chloe");

        Observable.merge(source1, source2)
                .subscribe(e -> System.out.println("Received: " + e));

        Observable<String> interval1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "interval1: " + e);
        Observable<String> interval2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "interval2: " + e);

        //Observable.merge(interval1, interval2)
        //        .subscribe(e -> System.out.println("Received: " + e));

        //Thread.sleep(10000);

        Observable.concat(interval1, interval2)
                .subscribe(e -> System.out.println("Received2: " + e));

        Thread.sleep(5000);
    }
}
