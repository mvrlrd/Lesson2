package ru.mvrlrd.lesson2.task2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import ru.mvrlrd.lesson2.R;

//2
//Создать активити. В активити 3 кнопки.
// Одна кнопка называется “Подписаться”,
// вторая - “Отписаться”,
// треться - “Спам”.
// Спам должен приходить (сообщения в лог) только, если вы на него подписались.
// Спам присылается только по нажатию кнопки “Спам”.
// Использовать паттерн “Наблюдатель”.
// При нажатии кнопки “Отписаться” спам должен перестать приходить
// (перестать приходить сообщения в лог).
// Сообщения должны содержать имя потока.
// Выполнить без RxJava
public class SecondActivity extends AppCompatActivity {

    private final static String TAG = "Info: ";
    Button subscribeButton, unsubscribeButton, spamButton;
    Subscribe subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        subscribe = new Subscribe();

        subscribeButton = findViewById(R.id.subscribe);
        unsubscribeButton = findViewById(R.id.unsubscribe);
        spamButton = findViewById(R.id.spam);
    }

    public void onClickButtonSubscribe(View view) {
        if (subscribe.isFlag()){
            Log.d(TAG, "already subscribed " + Thread.currentThread().getName());
        }else {
            subscribe.subscribeObserver();
            Log.d(TAG, "subscribed " + Thread.currentThread().getName());
        }
    }

    public void onClickButtonUnsubscribe(View view) {
        if(!subscribe.isFlag()){
            Log.d(TAG, "already unsubscribed " + Thread.currentThread().getName());
        }else {
            subscribe.unsubscribeObserver();
            Log.d(TAG, "unsubscribed " + Thread.currentThread().getName());
        }
    }

    public void onClickButtonSpam(View view) {
       subscribe.notifyAllObservers();
    }
}

