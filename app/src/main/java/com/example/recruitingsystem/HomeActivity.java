package com.example.recruitingsystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Form;
import classes.FragmentMap;
import classes.Question;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "mytag" ;
    MainFragment fragment;
    HashMap<Integer , Integer> fragmentMap;
    private DatabaseReference myRef;
    FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private FragmentMap fragmentHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);






        FloatingActionButton fab = findViewById(R.id.fab_Form);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        fragmentHashMap = new FragmentMap();
        fragmentMap = fragmentHashMap.getViewFragmentMap();
//        FragmentClassMap = new HashMap<Integer , Integer>();

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String userTypeId = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    //        MainFragment mainFragment = new MainFragment();
    //        mainFragment.setFragment(R.layout.fragment_email_verification);
    //        FragmentManager fm = getSupportFragmentManager();
    //        FragmentTransaction ft = fm.beginTransaction();
    //        ft.replace(R.id.fragment2,mainFragment);
    //        ft.commit();
    }

    public void fab(View view) {
        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signout:
                //Write your code
                mAuth.signOut();
                startActivity(new Intent(this,MainActivity.class));
                Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    public void viewMainFragment(View view)
    {
//        int layoutFragment = R.layout.id_elfragment
        Log.d(TAG, "viewMainFragment: start");
        int layoutFragment = fragmentMap.get(view.getId());
        fragment = new MainFragment();
        fragment.setFragment(layoutFragment);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment2,fragment);
        ft.commit();
        Log.d(TAG, "viewMainFragment: end");
    }





    public void AddForm()
    {
//        String id = dataSnapshot.child("id").toString();
//        String name = dataSnapshot.child("name").toString();
//        String creatorId = dataSnapshot.child("creatorId").toString();
//        String departmentId = dataSnapshot.child("departmentId").toString();

        String name = "first form";
        String creatorId = "creatorId";
        String departmentId = "departmentId";
        ArrayList<Question> questions = new ArrayList<>();
        String formId = "formId";;
        String questionScript = "how are you?";
        String dataType = "text";
        questions.add(new Question(questionScript , dataType , creatorId , formId));
        questions.add(new Question(questionScript , dataType , creatorId , formId));
        questions.add(new Question(questionScript , dataType , creatorId , formId));
        questions.add(new Question(questionScript , dataType , creatorId , formId));
        questions.add(new Question(questionScript , dataType , creatorId , formId));

        Form form = new Form(name , creatorId , departmentId , questions);
        myRef= database.getReference().child("forms");
        myRef.setValue(form);

    }



    public void readForm()
    {
        final String formName = "first form";
        myRef= database.getReference().child("forms");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                String value = dataSnapshot.getKey();
//                String value = dataSnapshot.getRef().push().getKey();
                String table = "name";
                String name = dataSnapshot.child(table).getValue().toString();
                if(name.equals(formName)){
                    Toast.makeText(HomeActivity.this, "hello" , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    public void deleteForm()
    {
        final String formName = "second Form";
        final String table = "name";
        myRef= database.getReference().child("forms");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                    String name = appleSnapshot.child(table).getValue().toString();
                    Log.d(TAG, "onDataChange: "+name);
//                    Toast.makeText(MainActivity.this, name , Toast.LENGTH_LONG).show();
                    if(name.equals(formName)){
                        appleSnapshot.getRef().removeValue();
//                        String x = String.valueOf(dataSnapshot.getValue());
//                        Toast.makeText(MainActivity.this, name , Toast.LENGTH_LONG).show();
                        Toast.makeText(HomeActivity.this, "done" , Toast.LENGTH_LONG).show();
                        break;
                    }
//                        appleSnapshot.getRef().removeValue();
//                    String x = String.valueOf(dataSnapshot.getValue());
//                        Toast.makeText(MainActivity.this, "appleSnapshot = "+name , Toast.LENGTH_LONG).show();


                }

                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                String value = dataSnapshot.getKey();
//                String value = dataSnapshot.getRef().push().getKey();
//                String name = dataSnapshot.child(table).getValue().toString();
//                if(name.equals(formName)){
//                    dataSnapshot.getRef().removeValue();
////                    String x = String.valueOf(dataSnapshot.getValue());
//                    Toast.makeText(MainActivity.this, "done" , Toast.LENGTH_LONG).show();
//                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }



}
