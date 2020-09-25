package com.ekremc.chapter6;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class _04_ZipAndCombineLatest {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> ob1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);
        Observable<Long> ob2 = Observable.interval(1, TimeUnit.SECONDS).take(10);

        Observable
                //.zip(ob1, ob2, (e1, e2) -> "Source1: " + e1 + " Source 2: " + e2)
                .combineLatest(ob1, ob2, (e1, e2) -> "Source1: " + e1 + " Source 2: " + e2)
                .subscribe(System.out::println);

        Thread.sleep(20000);
    }
}
