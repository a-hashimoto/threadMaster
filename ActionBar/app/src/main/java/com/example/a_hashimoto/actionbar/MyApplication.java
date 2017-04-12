package com.example.a_hashimoto.actionbar;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by a-hashimoto on 2017/03/22.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        OkHttpClient client = new OkHttpClient();
        client.networkInterceptors().add(new StethoInterceptor());


    }
}
