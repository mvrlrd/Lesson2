package ru.mvrlrd.lesson2.task2;

import android.os.AsyncTask;
import android.util.Log;

public class SpamEmitter implements Observer {
    private final static String TAG ="Message: ";
    private AsyncTaskExample taskExample;

    @Override
    public void updateObserver(boolean doSendSpam) {
        if (doSendSpam) {
            if(taskExample==null) {
                taskExample = new AsyncTaskExample();
                taskExample.execute();
            }
        }else {
            cancelSendingSpam();
        }
    }
    private void cancelSendingSpam(){
        if((taskExample!=null)&&(!taskExample.isCancelled())){
            taskExample.cancel(true);
            taskExample=null;
        }
    }

    private static class AsyncTaskExample extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try{
                while(!isCancelled()){
                    Log.d(TAG, "SPAM SPAM SPAM SPAM   "+Thread.currentThread().getName());
                    isCancelled();
                    Thread.sleep(1000);
                    isCancelled();
                }
            }catch (InterruptedException e){
//                e.printStackTrace();
            }
             return null;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.d(TAG, Thread.currentThread().getName()+"   ASYNC thread was cancelled");
        }
    }
}
