package com.example.a_hashimoto.threadmaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.thread_button)
    View Button;

    @BindView(R.id.thread_button2)
    View Button2;

    @BindView(R.id.thread_button3)
    View Button3;

    @BindView(R.id.tab_fragment)
    View tabFragment;
//
//    @BindView(R.id.image_view)
//    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        new Unbinder;
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search_bar) {
            Intent intent = new Intent(this, SearchableActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.thread_button)
    public void goToSearchableActivity() {
        tabFragment.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, SearchableActivity.class);
        startActivity(intent);
    }




}
