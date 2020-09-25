package com.ekremc.chapter4;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class _06_Variants {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alex", "Justin", "Jack");
        Observable<String> emptySource = Observable.empty();

        // Single
        source
                .first("Name")
                .subscribe(System.out::println);

        Single
                .just("Alex")
                .subscribe(System.out::println);

        // Maybe
        emptySource
                .firstElement()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        Maybe
                .empty()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        // Completable
        Completable completable = Completable.complete();

        System.out.println();

        completable.subscribe(() -> System.out.println("Completable Completed!"));

        Completable
                .fromRunnable(() -> System.out.println("Some process executing!"))
                .subscribe(() -> System.out.println("The process executed succesfully"));
    }
}
