package ru.mvrlrd.lesson2.task1;

import androidx.appcompat.app.AppCompatActivity;
import ru.mvrlrd.lesson2.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

// Task #1
//Создать активити. В активити 1 кнопка.
//Сделать с помощью AsyncTask.
// При нажатии на кнопку приходит сообщение в лог, что метод, вызвавший AsyncTask,
// завершён.
//Также приходит 5 сообщений в лог каждые 1 секунду.
//Сообщения должны содержать имя потока.



public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Info: ";
    private final static String TAG2 = "Async: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view) {
        new AsyncTaskExample().execute();
        Log.d(TAG,"method finished "+ Thread.currentThread().getName());
    }

    private static class AsyncTaskExample extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids){
            try{
            for (int i = 0; i < 5; i++) {
                Log.d(TAG2, Thread.currentThread().getName()+" "+i);
                Thread.sleep(1000);
            }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
    }






}
