package com.ekremc.chapter7;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class _04_UnicastSubject {

    public static void main(String[] args) throws InterruptedException {
        @NonNull UnicastSubject<Long> subject = UnicastSubject.create();

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .subscribe(subject);

        Thread.sleep(2000);

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

        Thread.sleep(2000);

        // subject.subscribe(e -> System.out.println("Subscriber 2: " + e)); // it throws exception

    }

    /*
        Subscriber 1: 0
        Subscriber 1: 1
        Subscriber 1: 2
        Subscriber 1: 3
        Subscriber 1: 4
        Subscriber 1: 5
        Subscriber 1: 6
        Subscriber 1: 7
     */
}
