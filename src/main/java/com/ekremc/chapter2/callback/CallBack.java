package com.ekremc.chapter2.callback;

public interface CallBack {

    void pushData(String data);

    void pushComplete();

    void pushError(Exception ex);
}
