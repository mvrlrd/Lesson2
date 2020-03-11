package ru.mvrlrd.lesson2.task3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.mvrlrd.lesson2.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//3
//Активити состоит из двух кнопок.
// По нажатию на первую, начинает приходить сообщения.
// По нажатию на вторую - отписка от сообщений.
// Реализовать с помощью RxJava

public class ThirdActivity extends AppCompatActivity {
    private static final String TAG = "ThirdActivity";
    private Observable <String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        SpamPresenter spamPresenter = new SpamPresenter();
        observable = spamPresenter.sentSpam();
    }

    public void onClickSubscribeButton(View view) {
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
                ThirdActivity.this.disposable = d;
            }
            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName() + " : " + s);
            }
            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }
            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
    }

    public void onClickUnsubscribeButton(View view) {
        disposable.dispose();
    }
}