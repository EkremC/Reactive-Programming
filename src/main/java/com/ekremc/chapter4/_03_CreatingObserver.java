package com.ekremc.chapter4;

import io.reactivex.rxjava3.core.Observable;

public class _03_CreatingObserver {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Orange", "Black", "Red");

        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        System.out.println();

        source.subscribe(System.out::println, Throwable::printStackTrace);

        System.out.println();

        source.subscribe(System.out::println);
    }
}
