package ru.mvrlrd.lesson2.task11;

import android.util.Log;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

class Model {
    private static final String TAG ="Model";

    Single<String> requestToServer(){
        return Single.create((SingleOnSubscribe<String>) emitter->{
            String json = "{'name':'obulenie','surname':'zbs'}";
            Log.d(TAG,"requestToServ: "+ Thread.currentThread().getName()+" "+json);
            emitter.onSuccess(json);
        }).subscribeOn(Schedulers.io());
    }
}
