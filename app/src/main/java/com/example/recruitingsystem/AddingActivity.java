package com.example.recruitingsystem;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import Adapters.QuestionAdapter;

public class AddingActivity extends AppCompatActivity {

    private EditText question_Edtext;
    ArrayList<String> questions;
    QuestionAdapter adapter;
    RecyclerView recyclerView;
    private EditText formName;
    private Spinner committee_spinner;
    private DatabaseReference myRef;
    FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private String TAG = "addingActivity";

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


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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


    public void submitForm(View view)
    {
        AddForm();
//        formName = findViewById(R.id.formName);
//        committee_spinner = findViewById(R.id.committee_spinner);
//
//        String name = formName.getText().toString();
//        String creatorId = mAuth.getCurrentUser().getUid();
//        String departmentId = "departmentId";
//        String dataType = "text";
//
//        ArrayList<Question> questionObjects = new ArrayList<>();
//
//        for (int i = 0; i < adapter.getItemCount(); i++) {
//            String questionScript = adapter.getQuestions().get(i);
//            questionObjects.add(new Question(questionScript , dataType , creatorId ));
//        }
//
//        Form form = new Form(name , creatorId , departmentId , questionObjects);
//        myRef= database.getReference().child("forms");
//        Log.d(TAG, "submitForm: "+myRef);
//        myRef.setValue(form);
//
////        startActivity(new Intent(this,HomeActivity.class));
//        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
    }

    public void AddForm()
    {

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

//        Log.d(TAG, "AddForm: start");
//        database = FirebaseDatabase.getInstance();
//        mAuth = FirebaseAuth.getInstance();
//        String name = "first form";
//        String creatorId = "creatorId";
//        String departmentId = "departmentId";
//        ArrayList<Question> questions = new ArrayList<>();
//        String formId = "formId";;
//        String questionScript = "how are you?";
//        String dataType = "text";
//        questions.add(new Question(questionScript , dataType , creatorId , formId));
//        questions.add(new Question(questionScript , dataType , creatorId , formId));
//        questions.add(new Question(questionScript , dataType , creatorId , formId));
//
//
//        myRef= database.getReference();
//        myRef.setValue(new Form("second Form" , creatorId , departmentId , questions));
//        myRef.push().setValue(new Form("third Form" , creatorId , departmentId , questions));
//        myRef.push().setValue(new Form("hellllllll Form", creatorId , departmentId , questions));
//        myRef.push().setValue(new Form("fifth Form" , creatorId , departmentId , questions));
//
//        Log.d(TAG, "AddForm: end");
    }


}
