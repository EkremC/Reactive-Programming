package com.ekremc.chapter2.callback;

public class CallBackDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread is running: " + Thread.currentThread().getName());

        Runnable r = new Runnable() {
            public void run() {
                new CallBackDemo().runningAsync(new CallBack() {
                    public void pushData(String data) {
                        System.out.println("Callback data : " + data);
                    }

                    public void pushComplete() {
                        System.out.println("Callback done!");
                    }

                    public void pushError(Exception ex) {
                        System.out.println("Got an exception: " + ex);
                    }
                });
            }
        };

        Thread t = new Thread(r);
        t.start();

        Thread.sleep(2000);

        System.out.println("Main thread completed!");
    }

    private void runningAsync(CallBack callBack) {
        System.out.println("I am running in separate thread: " + Thread.currentThread().getName());
        sleep(1000);
        callBack.pushData("data1");
        callBack.pushData("data2");
        callBack.pushData("data3");

        callBack.pushError(new RuntimeException("Oops!"));
        callBack.pushComplete();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
