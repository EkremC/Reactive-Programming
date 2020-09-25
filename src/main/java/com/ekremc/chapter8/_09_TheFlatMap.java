package com.ekremc.chapter8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

public class _09_TheFlatMap {

    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .flatMap(e -> Observable.just(e)
                        .subscribeOn(Schedulers.computation())
                .map(str -> compute(str)))
                .subscribe(System.out::println);

        Thread.sleep(7000);
    }

    private static String compute(String str) {
        return str + " : Printed By: " + Thread.currentThread().getName() + " at: " + LocalTime.now();
    }
}
