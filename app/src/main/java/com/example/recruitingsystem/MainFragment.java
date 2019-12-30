package com.example.recruitingsystem;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import classes.Form;


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
        else if(getFragment() == R.layout.fragment_form)
        {
            View rootView = inflater.inflate(R.layout.fragment_form, container, false);
            RecyclerView recyclerView = rootView.findViewById(R.id.forms_List);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            FormList(recyclerView);
            return rootView;
        }
        return inflater.inflate(this.fragment, container, false);


    }





    public void FormList(RecyclerView recyclerView )
    {
        // Inflate the layout for this fragment

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String creatorId = "creatorId";
        String departmentId = "departmentId";

        ArrayList<Form> forms = new ArrayList<>();

        Form f1 = new Form("1", "second form", creatorId, departmentId);
        Form f2 = new Form("2", "second form", creatorId, departmentId);
        Form f3 = new Form("3", "third form", creatorId, departmentId);
        forms.add(f1);
        forms.add(f2);
        forms.add(f3);
//        forms.add(new Form(id, name, creatorId, departmentId));
//        forms.add(new Form("2", "second form", creatorId, departmentId));
//        forms.add(new Form("3", "third form", creatorId, departmentId));

        Adapter adapter = new Adapter(forms);
        Log.d(TAG, "FormList: "+ adapter.getItemCount());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

//
//        adapter.setClickListener(getContext());



    }




}
