package com.ekremc.chapter10;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class _03_FlowableCreation {

    public static void main(String[] args) throws InterruptedException {
        Flowable.create(emitter -> {
            for (int i = 0; i < 500; i++) {
                if (emitter.isCancelled()) {
                    return;
                }
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(System.out::println);

        Thread.sleep(2000);
    }
}
