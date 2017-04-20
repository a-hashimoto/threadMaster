package com.example.a_hashimoto.threadmaster;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.Flowable;

/**
 * Created by a-hashimoto on 2017/04/12.
 */

public class RxJavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Flowable<String> flowable = Flowable.fromArray("A", "B", "C", "D", "E");
        flowable.subscribe(new DebugSubscriber<String>());
        super.onCreate(savedInstanceState);
    }
}
