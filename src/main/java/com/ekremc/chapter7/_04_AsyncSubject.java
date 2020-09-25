package com.ekremc.chapter7;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class _04_AsyncSubject {

    public static void main(String[] args) {
        AsyncSubject<Object> subject = AsyncSubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }

    /*
        Subscriber 1: e
        Subscriber 2: e
     */
}
