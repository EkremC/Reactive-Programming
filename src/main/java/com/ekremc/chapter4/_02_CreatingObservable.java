package com.ekremc.chapter4;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class _02_CreatingObservable {

    public static void main(String[] args) {
        // create
        Observable<Integer> source = Observable.create(
                e -> {
                    e.onNext(10);
                    e.onNext(11);
                    e.onNext(12);
                    e.onComplete();
                }
        );

        source.subscribe(System.out::println);

        // just
        System.out.println("Just");
        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);

        // iterable
        System.out.println("Iterable");
        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("Veli");
        list.add("Can");
        var listObservable = Observable.fromIterable(list);
        listObservable.subscribe(System.out::println);


        // defer
        System.out.println("Defer");
        Observable<String> defer = Observable.defer(
                () -> Observable.fromIterable(list)
        );

        defer.subscribe(System.out::println);
        list.add("Ahmet");
        defer.subscribe(System.out::println);
    }
}
