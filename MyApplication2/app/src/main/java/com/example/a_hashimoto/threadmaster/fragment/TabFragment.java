package com.example.a_hashimoto.threadmaster.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a_hashimoto.threadmaster.R;

/**
 * Created by hashimotoakira on 2017/02/10.
 */

public class TabFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab_fragment, container, false);
    }
}
