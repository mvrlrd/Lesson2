package ru.mvrlrd.lesson2.task2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Subscription implements Observable {
    private final static String TAG = "Info: ";
    private boolean isSubscribed;
    private List<Observer> observerList;

    public Subscription() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void subscribeObserver(Observer observer) {
        if (isSubscribed){
            Log.d(TAG, "already subscribed " + Thread.currentThread().getName());
        }else {
            observerList.add(observer);
            isSubscribed = true;
            Log.d(TAG, "subscribed " + Thread.currentThread().getName());
        }
    }

    @Override
    public void unsubscribeObserver(Observer observer) {
        if(isSubscribed){
            isSubscribed=false;
            notifyAllObservers();
            observerList.remove(observer);
            Log.d(TAG, "unsubscribed " + Thread.currentThread().getName());

        }else {
            Log.d(TAG, "already unsubscribed " + Thread.currentThread().getName());
        }
    }
    @Override
    public void notifyAllObservers() {
//        if (observerList.isEmpty()){
//
//        }
        for(Observer observer: observerList){
            observer.updateObserver(isSubscribed);
        }

    }
}
