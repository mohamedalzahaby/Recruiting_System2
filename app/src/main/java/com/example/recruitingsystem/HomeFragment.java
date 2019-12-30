package com.example.recruitingsystem;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    private int fragment;
    private static final String TAG  = "MainFragment";


    public HomeFragment() {
        // Required empty public constructor
        Log.d(TAG, "MainFragment: 1");
        this.fragment = -1;

    }


    public void setFragment(int fragment ) {
        this.fragment = fragment;
    }
    public int getFragment() {
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getFragment() == -1)
        {
            return inflater.inflate(R.layout.fragment_second_page, container, false);
        }
        return inflater.inflate(this.fragment, container, false);


    }

}
