package ru.mvrlrd.lesson2.task11;

import android.util.Log;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

class MessageHandler {
    private static final String TAG = "MessageHandler";
    private Model model;

    MessageHandler() {
        this.model = new Model();
    }

    void sentMessage() {
        Single<String> stringSingle = model.requestToServer();
        Disposable disposable = stringSingle.observeOn(AndroidSchedulers.mainThread()).subscribe(json -> {
            Log.d(TAG, "request: " + Thread.currentThread().getName() + "  " + json);
        });
    }
}
