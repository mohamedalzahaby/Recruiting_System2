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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import classes.FragmentMap;
import classes.User;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.recruitingsystem.MESSAGE";
    private static final String TAG = "mytag" ;
    FragmentMap fragmentHashMap;
    MainFragment fragment;
    HashMap<Integer , Integer>  fragmentMap;
    HashMap<Integer , Integer>  FragmentClassMap;


    FirebaseDatabase database;
    DatabaseReference myRef;
    private FirebaseAuth mAuth;
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
    // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

//        DatabaseReference myRef = database.getReference("message");

//        myRef.setValue("Hello, World!");
//        mAuth.signOut();





    }


    @Override
    public void onStart () {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    public void viewMainFragment(View view)
    {
//        int layoutFragment = R.layout.id_elfragment
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
//        EditText email = findViewById(R.id.usrusr);
//        EditText password = findViewById(R.id.pswrd);
        String email = "mohamedazahaby@gmail.com";
        String password = "mohamedazahaby123";
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    mAuth.getCurrentUser().reload();
                    FirebaseUser user = mAuth.getCurrentUser();
                    if (user.isEmailVerified()) {
                        final String user_id=user.getUid();
                        myRef= database.getReference().child("users").child(user_id);
                        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            String userType_Column = "userTypeId";
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String userType = dataSnapshot.child(userType_Column).getValue().toString();
                                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                                intent.putExtra(EXTRA_MESSAGE, userType);
                                startActivity(intent);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Toast.makeText(MainActivity.this, "Database Error", Toast.LENGTH_SHORT).show();

                            }
                        });

                        //Toast.makeText(getApplicationContext(),"You are in =)",Toast.LENGTH_LONG).show();
                        //System.out.println("logged in");
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Check your email first...",Toast.LENGTH_LONG).show();
                        //System.out.println("Check email");
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }




    public void signUp(View view)
    {
        int userType = 1;
        String name = "mohamed";
//        String email = "mohamed1501643@miuegypt.edu.eg";
        String email = "mohamedazahaby@gmail.com";
        String password = "mohamedazahaby123";
        boolean emailVerified = false;
        boolean ismale = true;

        myRef = database.getReference("users");


        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            sendVerificationEmail(user);
//                            updateUI(user);
                            if (user.isEmailVerified())
                            {
                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                                Intent intent = new Intent(MainActivity.this , HomeActivity);
                            }
                            else
                            {
                                startActivity(new Intent(MainActivity.this, VerificationActivity.class));
//                                int layoutFragment = R.layout.

//                                fragment = new MainFragment();
//                                fragment.setFragment(R.layout.fragment_email_verification);
//                                Toast.makeText(MainActivity.this, ""+fragment.getFragment(), Toast.LENGTH_SHORT).show();
//                                FragmentManager fm = getSupportFragmentManager();
//                                FragmentTransaction ft = fm.beginTransaction();
//                                ft.replace(R.id.fragment1,fragment);
//                                ft.commit();
                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                    }
        });
        mAuth.signOut();

//        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful())
//                {
//                    FirebaseUser user = auth.getCurrentUser();
//                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>()
//                    {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//
//                            if (task.isSuccessful())
//                            {
//                                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_LONG).show();
//                                String uid = auth.getCurrentUser().getUid();
//                                User mohamed = new User(uid,1,"mohamed","mohamedazahaby@gmail.com",false,"hello", true);
//                                myRef.child(uid).setValue(mohamed);
//                                Toast.makeText(getApplicationContext(), "mohamed Registered", Toast.LENGTH_LONG).show();
//                            }
//                            else
//                            {
//                                Log.i("Success", "No");
//                            }
//                        }
//                    });
//
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//        auth.signOut();





    }


    //Change UI according to user data.
    public void  updateUI(FirebaseUser account){
        if(account != null){
            Toast.makeText(this,"U Signed In successfully",Toast.LENGTH_LONG).show();
//            startActivity(new Intent(this,AnotherActivity.class));
        }else {
            Toast.makeText(this,"U Didnt signed in",Toast.LENGTH_LONG).show();
        }
    }




    private void sendVerificationEmail(FirebaseUser user)
    {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
//                            // email sent
//
//
//                            // after email is sent just logout the user and finish this activity
//                            FirebaseAuth.getInstance().signOut();
////                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
//                            finish();

                            String uid = mAuth.getCurrentUser().getUid();
                            User mohamed = new User(uid,1,"mohamed","mohamedazahaby@gmail.com",false,"hello", true);
                            myRef.child(uid).setValue(mohamed);
                            Toast.makeText(getApplicationContext(), "mohamed Registered", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            // email not sent, so display message and restart the activity or do whatever you wish to do

                            //restart this activity
                            overridePendingTransition(0, 0);
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());

                        }
                    }
                });
    }




    private void checkIfEmailVerified(FirebaseUser user)
    {
//        user = mAuth.getCurrentUser();

        if (user.isEmailVerified())
        {
            // user is verified, so you can finish this activity or send user to activity which you want.
            finish();
            Toast.makeText(MainActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // email is not verified, so just prompt the message to the user and restart this activity.
            // NOTE: don't forget to log out the user.
            mAuth.signOut();

            //restart this activity

        }
    }


}