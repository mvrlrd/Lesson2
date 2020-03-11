package ru.mvrlrd.lesson2.task2;

import android.util.Log;

public class Subscription implements Observable {
    private final static String TAG = "Info: ";
    private boolean isSubscribed;
    private Observer spamEmitter;

    Subscription() {
        this.spamEmitter = new SpamEmitter();
    }

    @Override
    public void subscribeObserver() {
        if (isSubscribed){
            Log.d(TAG, "already subscribed " + Thread.currentThread().getName());
        }else {
            isSubscribed = true;
            Log.d(TAG, "subscribed " + Thread.currentThread().getName());
        }
    }

    @Override
    public void unsubscribeObserver() {
        if(isSubscribed){
            isSubscribed=false;
            Log.d(TAG, "unsubscribed " + Thread.currentThread().getName());
            notifyAllObservers();
        }else {
            Log.d(TAG, "already unsubscribed " + Thread.currentThread().getName());
        }
    }
    @Override
    public void notifyAllObservers() {
        spamEmitter.updateObserver(this.isSubscribed);
    }
}
