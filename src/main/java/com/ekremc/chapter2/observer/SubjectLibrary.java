package com.ekremc.chapter2.observer;

public interface SubjectLibrary {

    public void subscribeObserver(Observer ob);

    public void unsubscribeObserver(Observer ob);

    public void notifyObserver();
}
