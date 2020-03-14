package ru.mvrlrd.lesson2.lesson3task1;

import android.util.Log;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;



class SpamPresenter {
    private static final String TAG = "SpamPresenter";

    Observable<String> sentSpam() {
        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    String spam = "spam " + i;
                    Log.d(TAG, spam + " " + Thread.currentThread().getName());
                    emitter.onNext(spam);
                }
            } catch (InterruptedException e) {
                Log.d(TAG, "spam not disposed");
            }
        }).subscribeOn(Schedulers.io());
        }
}
