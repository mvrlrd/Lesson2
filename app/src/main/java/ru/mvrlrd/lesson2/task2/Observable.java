package ru.mvrlrd.lesson2.task2;

public interface Observable {
    void subscribeObserver();
    void unsubscribeObserver();
    void notifyAllObservers();
}
