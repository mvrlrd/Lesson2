package ru.mvrlrd.lesson2.task2;

import android.os.Bundle;
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
    Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        subscription = new Subscription();

        subscribeButton = findViewById(R.id.subscribe);
        unsubscribeButton = findViewById(R.id.unsubscribe);
        spamButton = findViewById(R.id.spam);
    }

    public void onClickButtonSubscribe(View view) {
            subscription.subscribeObserver();
    }

    public void onClickButtonUnsubscribe(View view) {
            subscription.unsubscribeObserver();
    }

    public void onClickButtonSpam(View view) {
       subscription.notifyAllObservers();
    }
}

