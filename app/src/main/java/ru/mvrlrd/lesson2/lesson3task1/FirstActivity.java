package ru.mvrlrd.lesson2.lesson3task1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.mvrlrd.lesson2.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//3
//Активити состоит из двух кнопок.
// По нажатию на первую, начинает приходить сообщения.
// По нажатию на вторую - отписка от сообщений.
// Реализовать с помощью RxJava + лямбда-выражениями.
// Для view и слушателей применить ButterKnife

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";
    private Observable <String> observable;
    private Disposable disposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        SpamPresenter spamPresenter = new SpamPresenter();
        observable = spamPresenter.sentSpam();

    }
    @OnClick({R.id.subscribe_task3})
    public void onClickSubscribeButton(View view) {
        disposable = observable.map(s->s).
                observeOn(AndroidSchedulers.mainThread()).subscribe(string ->{
            Log.d(TAG,"onNext: "+string);
        }, throwable -> {
            Log.d(TAG,"onError");
                },()->{
            Log.d(TAG,"onComplete: ");
                });
    }
    @OnClick({R.id.unsubscribe_task3})
    public void onClickUnsubscribeButton(View view) {
        disposable.dispose();
    }
}