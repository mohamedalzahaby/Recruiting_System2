package com.example.recruitingsystem;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import Adapters.QuestionAdapter;
import classes.Form;
import classes.Question;

public class AddingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();



//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);



        // Spinner element
        committee_spinner = findViewById(R.id.committee_spinner);

        // Spinner click listener
        committee_spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("HR");
        categories.add("PR");
        categories.add("FR");
        categories.add("Marketing");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        committee_spinner.setAdapter(dataAdapter);

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
        formName = findViewById(R.id.formName);

        String name = formName.getText().toString();
        mAuth.getCurrentUser().reload();
        String creatorId = mAuth.getCurrentUser().getUid();
        String departmentId = "departmentId";
        String dataType = "text";
        ArrayList<Question> questionObjects = new ArrayList<>();

        for (int i = 0; i < adapter.getItemCount(); i++) {
            String questionScript = adapter.getQuestions().get(i);
            questionObjects.add(new Question(questionScript , dataType , creatorId ));
        }

        Form form = new Form(name , creatorId , departmentId , questionObjects);
        myRef= database.getReference().child("forms");
        myRef.push().setValue(form);

        startActivity(new Intent(this,HomeActivity.class));
        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
        String item = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // On selecting a spinner item
        String item = adapterView.getItemAtPosition(0).toString();

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }
}
