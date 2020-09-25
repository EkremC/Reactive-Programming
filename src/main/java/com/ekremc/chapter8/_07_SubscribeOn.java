package com.ekremc.chapter8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class _07_SubscribeOn {

    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())
                .map(String::toUpperCase)
                .subscribeOn(Schedulers.newThread())
                .filter(e -> e.startsWith("P"))
                .subscribe(e -> print(e));

        Thread.sleep(6000);
    }

    private static void print(String e) {
        System.out.println(e + " : Printed By :" + Thread.currentThread().getName());
    }
}
