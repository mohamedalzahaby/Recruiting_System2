package com.example.recruitingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import classes.FragmentMap;
import classes.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mytag" ;
    FragmentMap fragmentHashMap;
    MainFragment fragment;
    HashMap<Integer , Integer>  fragmentMap;
    HashMap<Integer , Integer>  FragmentClassMap;


    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseAuth auth;
    int ctr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentHashMap = new FragmentMap();

        fragmentMap = fragmentHashMap.getViewFragmentMap();
        FragmentClassMap = new HashMap<Integer , Integer>();

        ctr = 1;
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();


    }


    public void viewMainFragment(View view)
    {
        int layoutFragment = fragmentMap.get(view.getId());
        fragment = new MainFragment();
        fragment.setFragment(layoutFragment);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment1,fragment);
        ft.commit();
    }

    public void login(View view)
    {
        Button btn_signin = findViewById(R.id.sin);
        EditText username = findViewById(R.id.usrusr);
        EditText password = findViewById(R.id.pswrd);

//        myRef = database.getReference("message");
//        myRef.setValue("Hello, dddd!");

//        ++ctr;
//        String myCtr = String.valueOf(ctr);
//
//        myRef = database.getReference("users").child(myCtr);
//        User mohamed = new User(1,1,"mohamed","mohamedazahaby@gmail.com",false,"hello", true);
//        myRef.setValue(mohamed);

        Toast.makeText(this, "Hello, dddddd!", Toast.LENGTH_SHORT).show();
    }




    public void signUp(View view)
    {
        int userType = 1;
        String name = "mohamed";
        String email = "mohamedazahaby@gmail.com";
        String password = "password";
        boolean emailVerified = false;
        boolean ismale = true;
        myRef = database.getReference("users");


        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    FirebaseUser user = auth.getCurrentUser();
                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_LONG).show();
                                String uid = auth.getCurrentUser().getUid();
                                User mohamed = new User(uid,1,"mohamed","mohamedazahaby@gmail.com",false,"hello", true);
                                myRef.child(uid).setValue(mohamed);
                                Toast.makeText(getApplicationContext(), "mohamed Registered", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Log.i("Success", "No");
                            }
                        }
                    });

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
        auth.signOut();






    }



}
