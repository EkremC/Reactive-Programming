package com.ekremc.chapter7;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class _04_BehaviorSubject {

    public static void main(String[] args) {
        BehaviorSubject<Object> subject = BehaviorSubject.create();

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
        Subscriber 1: a
        Subscriber 1: b
        Subscriber 1: c
        Subscriber 2: c
        Subscriber 1: d
        Subscriber 2: d
        Subscriber 1: e
        Subscriber 2: e
     */
}
