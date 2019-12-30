package com.example.recruitingsystem;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import Adapters.QuestionAdapter;

public class AddingActivity extends AppCompatActivity {

    private EditText question_Edtext;
    ArrayList<String> questions;
    QuestionAdapter adapter;
    RecyclerView recyclerView;
//    private AddingFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);




        question_Edtext = findViewById(R.id.question_Edtext);
        questions = new ArrayList<>();
        adapter = new QuestionAdapter(questions);
        recyclerView = (RecyclerView) findViewById(R.id.rvQuestions);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }




    public void addQuestion(View view) {
        BlankFragment fragment = new BlankFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentQuestions, fragment);
        ft.commit();

        String question = question_Edtext.getText().toString();
//        questions.add(question);
        adapter.addQuestions(question);
        adapter.notifyDataSetChanged();

        recyclerView.setItemAnimator(new DefaultItemAnimator());





    }

    public void send(View view) {

    }
}
