package com.ekremc.chapter9;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class _02_Throttling {

    public static void main(String[] args) {
        Observable<Object> source = Observable.create(emitter -> {
            emitter.onNext("A");

            Thread.sleep(200);
            emitter.onNext("B");

            Thread.sleep(100);
            emitter.onNext("C");

            Thread.sleep(400);
            emitter.onNext("D");

            Thread.sleep(300);
            emitter.onNext("E");

            Thread.sleep(800);
            emitter.onNext("F");

            Thread.sleep(900);
            emitter.onNext("X");

            Thread.sleep(600);
            emitter.onNext("Y");

            Thread.sleep(1000);
            emitter.onNext("Z");

            emitter.onComplete();
        });

        source
                .throttleWithTimeout(700, TimeUnit.MILLISECONDS)
                .subscribe(
                        item -> System.out.println("onNext: " + item),
                        Throwable::printStackTrace,
                        () -> System.out.println("onComplete")
                );
    }
}

        /*
        .throttleFirst(1000, TimeUnit.MILLISECONDS)
            onNext: A
            onNext: E
            onNext: X
            onNext: Z
            onComplete

         .throttleLast(1000, TimeUnit.MILLISECONDS) == sample
            onNext: D
            onNext: F
            onNext: X
            onNext: Y
            onComplete

            throttleWithTimeout(700, TimeUnit.MILLISECONDS)
            onNext: E
            onNext: F
            onNext: Y
            onNext: Z
            onComplete
         */
