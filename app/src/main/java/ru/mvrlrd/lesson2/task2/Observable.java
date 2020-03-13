package ru.mvrlrd.lesson2.task2;

public interface Observable {
    void subscribeObserver(Observer observer);
    void unsubscribeObserver(Observer observer);
    void notifyAllObservers();
}
