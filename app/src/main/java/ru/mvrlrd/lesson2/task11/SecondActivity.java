package ru.mvrlrd.lesson2.task11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mvrlrd.lesson2.R;
import android.os.Bundle;
import android.view.View;

// Task #
//Активити состоит из одной кнопки.
// По нажатию на первую, приходит одно сообщение.
//Реализовать с помощью RxJava + лямбда-выражениями (Single).
// Для view и слушателей применить ButterKnife



public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";
    private MessageHandler messageHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        messageHandler  = new MessageHandler();
    }

    @OnClick({R.id.button})
    public void onClickSubscribeButton(View view) {
        messageHandler.sentMessage();
    }

}
