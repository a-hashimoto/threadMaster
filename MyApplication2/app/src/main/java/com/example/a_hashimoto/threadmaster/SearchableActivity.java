package com.example.a_hashimoto.threadmaster;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class SearchableActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> TitleArrayList;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<String> CatchphraseArrayList;
    private ArrayList<Bitmap> ThumbnailArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
//
//        setSupportActionBar(toolbar);
//        Intent intent = getIntent();
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            doMySearch(query);
//        }
//        onSearchRequested();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        TitleArrayList = new ArrayList<>();
        TitleArrayList.add("cocoa");
        TitleArrayList.add("chino");
        TitleArrayList.add("rize");

        CatchphraseArrayList = new ArrayList<>();
        CatchphraseArrayList.add("peach");
        CatchphraseArrayList.add("blue");
        CatchphraseArrayList.add("perple");

        ThumbnailArrayList = new ArrayList<>();
        ThumbnailArrayList.add(BitmapFactory.decodeResource(getResources(), R.drawable.gotiusa));
        ThumbnailArrayList.add(BitmapFactory.decodeResource(getResources(), R.drawable.gotiusa));
        ThumbnailArrayList.add(BitmapFactory.decodeResource(getResources(), R.drawable.kemono));

        mAdapter = new MyAdapter(TitleArrayList, CatchphraseArrayList, ThumbnailArrayList);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.removeAllViews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void doMySearch(String query) {

    }
}
