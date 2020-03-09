package ru.mvrlrd.lesson2.task2;

import android.os.AsyncTask;
import android.util.Log;

public class SpamEmitter implements Observer {
    private final static String TAG ="SPAM SPAM SPAM";

    @Override
    public void updateObserver(boolean flag) {
        if (flag) {
            new AsyncTaskExample().execute();
        }
    }

    private static class AsyncTaskExample extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
             Log.d(TAG, Thread.currentThread().getName());
             return null;
        }
    }
}
