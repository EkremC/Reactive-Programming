package com.ekremc.chapter7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class _03_Subjects {

    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> source1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        Observable<Integer> source2 = Observable.just(50, 100, 150, 200)
                .subscribeOn(Schedulers.computation());

        PublishSubject<Object> subject = PublishSubject.create();

        subject.subscribe(System.out::println);

        source1.subscribe(subject);
        source2.subscribe(subject);

        Thread.sleep(10000);


        /*
       // one observable and multiple observer
        Observable<Integer> source1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        PublishSubject<Object> subject = PublishSubject.create();

        subject.subscribe(System.out::println);
        subject.subscribe(e -> System.out.println("The element is: " + e));

        source1.subscribe(subject);

        Thread.sleep(10000);

         */
    }
}
