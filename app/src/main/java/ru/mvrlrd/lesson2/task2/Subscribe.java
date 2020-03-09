package ru.mvrlrd.lesson2.task2;

import android.os.AsyncTask;
import android.util.Log;

public class Subscribe implements Observable {
    private boolean flag;
    private Observer spamEmitter;

    Subscribe() {
        this.spamEmitter = new SpamEmitter();
    }

    @Override
    public void subscribeObserver() {
        this.flag = true;
    }

    @Override
    public void unsubscribeObserver() {
        this.flag = false;
    }

    @Override
    public void notifyAllObservers() {
        spamEmitter.updateObserver(this.flag);
    }

    public boolean isFlag() {
        return flag;
    }
}
