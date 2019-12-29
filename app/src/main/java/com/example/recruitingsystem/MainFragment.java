package com.example.recruitingsystem;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import classes.Board;


public class MainFragment extends Fragment {

    private int fragment;
    private static final String TAG  = "MainFragment";


    public MainFragment() {
        // Required empty public constructor
        Log.d(TAG, "MainFragment: 1");
        this.fragment = -1;

    }
//    public MainFragment(int fragment) {
//        // Required empty public constructor
//        Log.d(TAG, "MainFragment: 1");
//        this.fragment = fragment;
//
//    }

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
            return inflater.inflate(R.layout.fragment_first_page, container, false);
        }
        if (getFragment() == 0)
        {
            return inflater.inflate(R.layout.fragment_second_page, container, false);
        }
        return inflater.inflate(this.fragment, container, false);


    }

//    public void mywatashiwahello(View view)
//    {
////        if (this.fragment)
//        Toast.makeText(getContext(), "watashiwaaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
//    }






}
