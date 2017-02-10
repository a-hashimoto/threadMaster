package com.example.a_hashimoto.threadmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.thread_button)
    View Button;

    @BindView(R.id.thread_button2)
    View Button2;

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
    public void deleteTabFragment(){
        tabFragment.setVisibility(View.INVISIBLE);
    }

}
