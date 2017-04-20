package com.example.a_hashimoto.threadmaster;

import android.util.Log;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by a-hashimoto on 2017/04/12.
 */

public class DebugSubscriber<T> extends DisposableSubscriber<T> {

    private String label;

    public DebugSubscriber() {
        super();
    }

    public DebugSubscriber(String label) {
        super();
        this.label = label;
    }

    @Override
    public void onNext(T data) {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            Log.d("gotiusa", threadName + ": " + data);
        } else {
            Log.d("gotiusa", threadName + ": " + label + ": " + data);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            Log.d("gotiusa", threadName + ": error" + String.valueOf(throwable));
        } else {
            Log.d("gotiusa", threadName + ": " + label + ": error =" + throwable);
        }
    }

    @Override
    public void onComplete() {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            Log.d("gotiusa", threadName + ": complete");
        } else {
            Log.d("gotiusa", threadName + ": " + label + "complete");
        }
    }
}

