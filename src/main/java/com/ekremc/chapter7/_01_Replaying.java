package com.ekremc.chapter7;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class _01_Replaying {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
                //.replay()
                //.replay(2)
                //.replay(1, TimeUnit.SECONDS)
                .replay(2, 4, TimeUnit.SECONDS)
                .autoConnect();

        source.subscribe(e -> System.out.println("Observer 1: " + e));

        Thread.sleep(5000);

        source.subscribe(e -> System.out.println("Observer 2: " + e));

        Thread.sleep(3000);
    }
}
