package com.ekremc.chapter9;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class _01_Buffering {

    public static void main(String[] args) throws InterruptedException {
       // Observable.range(1, 30)
       //         //.buffer(4)
       //         .buffer(4, 7)
       //         .subscribe(System.out::println);

        //Observable.interval(500, TimeUnit.MILLISECONDS)
        //        .buffer(1, TimeUnit.SECONDS, 2)
        //        .subscribe(System.out::println);

        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .buffer(interval)
                .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}

    /*
        buffer(4)
        [1, 2, 3, 4]
        [5, 6, 7, 8]
        [9, 10, 11, 12]
        [13, 14, 15, 16]
        [17, 18, 19, 20]
        [21, 22, 23, 24]
        [25, 26, 27, 28]
        [29, 30]

        buffer(4, 7)
        [1, 2, 3, 4]
        [8, 9, 10, 11]
        [15, 16, 17, 18]
        [22, 23, 24, 25]
        [29, 30]

        .buffer(1, TimeUnit.SECONDS)
        [0]
        [1, 2]
        [3, 4, 5]
        [6, 7]
        [8, 9]
        [10]
        [11, 12, 13]
        [14, 15]

        .buffer(1, TimeUnit.SECONDS, 2)
        [0]
        [1, 2]
        []
        [3, 4]
        []
        [5, 6]
        []
        [7, 8]
        []
        [9, 10]
        []
        [11, 12]
        []
        [13, 14]
        []
     */