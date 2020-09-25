package com.ekremc.chapter4;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class _07_Disposing {

    private static final CompositeDisposable compDisp = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        source.subscribe(e -> System.out.println("Observer1: " + e));
        source.subscribe(e -> System.out.println("Observer2: " + e));
        Disposable disposable = source.subscribe(e -> System.out.println("Observer3: " + e));
        source.subscribe(e -> System.out.println("Observer4: " + e)).dispose();
        Disposable dis1 = source.subscribe(e -> System.out.println("Observer5: " + e));
        Disposable dis2 = source.subscribe(e -> System.out.println("Observer6: " + e));

        Thread.sleep(5000);

        disposable.dispose();
        compDisp.addAll(dis1, dis2);
        compDisp.dispose();
        Thread.sleep(10000);

    }
}
