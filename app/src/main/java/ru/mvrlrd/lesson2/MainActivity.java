package ru.mvrlrd.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


//Создать активити. В активити 1 кнопка.
//      Сделать с помощью AsyncTask.
// При нажатии на кнопку приходит сообщение в лог, что метод, вызвавший AsyncTask, завершён.
//      Также приходит 5 сообщений в лог каждые 1 секунду.
//              Сообщения должны содержать имя потока.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
