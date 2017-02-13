package com.example.a_hashimoto.threadmaster;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.thread_button)
    View Button;

    @BindView(R.id.thread_button2)
    View Button2;

    @BindView(R.id.thread_button3)
    View Button3;

    @BindView(R.id.tab_fragment)
    View tabFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.thread_button)
    public void setTabFragment() {
        tabFragment.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.thread_button2)
    public void deleteTabFragment() {
        tabFragment.setVisibility(View.INVISIBLE);
    }

    static boolean enabled = true;
    private static final Runnable ENABLE_AGAIN = new Runnable() {
        @Override
        public void run() {
            Log.v("5.run:currentThread", Thread.currentThread().getName());
            enabled = true;
        }

        ;
    };

    @OnClick(R.id.thread_button3)
    public void onClick() {

        Log.v("0", "0");
        if (enabled) {
            Log.v("1.OnClick: currentThread", Thread.currentThread().getName());
            enabled = false;
            new Handler().postDelayed(func2, 3000);
        }
    }

    private final Runnable func2 = new Runnable() {
        @Override
        public void run() {

            doClick();

            findViewById(R.id.thread_button3).post(ENABLE_AGAIN);
        }
    };

    public void doClick() {
        Observable<String> observableGreeting =
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        //　購読が解除されている場合は処理をやめる
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }

                        //　1回目の通知をする
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        subscriber.onNext("Hello,World!");


                        Log.v("3.subscriber: currentThread", Thread.currentThread().getName());

                        //　購読解除されていない場合
                        if (!subscriber.isUnsubscribed()) {
                            //　完了したことを通知する
                            subscriber.onCompleted();
                        }
                    }
                });

        // Observableを購読し処理を開始する
        observableGreeting.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

                //　Observableからのデータをそのまま標準出力する
                Log.v("4.onCompleted:currentThread", Thread.currentThread().getName() + ": 完了しました");
            }

            @Override
            public void onError(Throwable e) {
                //　Observableからのデータをそのまま標準出力する
                Log.v("onError:currentThread", Thread.currentThread().getName() + ": Error");
            }

            @Override
            public void onNext(String item) {
                //　実行しているThread名の取得
                new Handler().postDelayed(func, 3000);
            }
        });
    }

    private final Runnable func = new Runnable() {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            //　Observableからのデータをそのまま標準出力する
            Log.v("2.onNext:currentThread", Thread.currentThread().getName() + ": ");
        }
    };
}
