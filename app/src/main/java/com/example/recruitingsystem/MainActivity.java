package com.example.recruitingsystem;

import androidx.annotation.NonNull;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import java.util.ArrayList;
import java.util.HashMap;

import classes.Form;
import classes.FragmentMap;
import classes.Question;
import classes.User;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.recruitingsystem.MESSAGE";
    FragmentMap fragmentHashMap;
    private static final String TAG = "mytag" ;
    MainFragment fragment;
    HashMap<Integer , Integer>  fragmentMap;
    HashMap<Integer , Integer>  FragmentClassMap;
    RadioGroup gender ;
    EditText fname;
    EditText myemail;
    EditText username;
    EditText mypassword;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        gender = (RadioGroup) findViewById(R.id.gender);

        fragmentHashMap = new FragmentMap();
        fragmentMap = fragmentHashMap.getViewFragmentMap();
        FragmentClassMap = new HashMap<Integer , Integer>();

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
    // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
//        mAuth.signOut();


        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


//        DatabaseReference myRef = database.getReference("message");

//        myRef.setValue("Hello, World!");
//        mAuth.signOut();


//        AddForm();
//        deleteForm();



//        int userType = 2;
//        String name = "mohamed";
//
////        String email = "mohamed1501643@miuegypt.edu.eg";
//        String email = "mohamed1501643@miuegypt.edu.eg";
//        String password = "mohamedazahaby123";
//        boolean emailVerified = false;
//        boolean ismale = true;


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
                viewMainFragmentbyid(R.layout.fragment_first_page);
                Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onStart () {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(this,HomeActivity.class));
            Toast.makeText(this,"U Signed In successfully",Toast.LENGTH_LONG).show();
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
        ft.replace(R.id.fragment1,fragment);
        ft.commit();
        Log.d(TAG, "viewMainFragment: end");
    }

    public void viewMainFragmentbyid(int layoutFragment)
    {
        fragment = new MainFragment();
        fragment.setFragment(layoutFragment);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment1,fragment);
        ft.commit();
        Log.d(TAG, "viewMainFragment: start");
    }

    public void login(View view)
    {
        Button btn_signin = findViewById(R.id.sin);
//        EditText email = findViewById(R.id.usrusr);
//        EditText password = findViewById(R.id.pswrd);
        String email = "mohamed1501643@miuegypt.edu.eg";
        String password = "Mohamedazahaby123";

//        Toast.makeText(this, email +" "+password, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "login: email: " +email +" password: "+password);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    mAuth.getCurrentUser().reload();
                    FirebaseUser user = mAuth.getCurrentUser();
                    if (user.isEmailVerified())
                    {
                        final String user_id=user.getUid();
                        myRef= database.getReference().child("users").child(user_id);
                        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            String userType_Column = "userTypeId";
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String userType = dataSnapshot.child(userType_Column).getValue().toString();
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
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
                        Toast.makeText(getApplicationContext(),"Verify your email first...",Toast.LENGTH_LONG).show();
                        //System.out.println("Check email");
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }




    public void signUp(View view)
    {
        Log.d(TAG, "signUp: 1");

        myemail = findViewById(R.id.emailSignUp);
        mypassword = findViewById(R.id.password);
        String email = myemail.getText().toString();
        Log.d(TAG, "signUp: 2");
        String password = mypassword.getText().toString();
        Log.d(TAG, "signUp: 3");

        myRef = database.getReference("users");

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();

                    sendVerificationEmail(user );
//                            updateUI(user);
                    if (user.isEmailVerified()){
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                                Intent intent = new Intent(MainActivity.this , HomeActivity);
                    }
                    else{
//                        startActivity(new Intent(MainActivity.this, VerificationActivity.class));
                        viewMainFragmentbyid(R.layout.fragment_first_page);
                        Toast.makeText(MainActivity.this, "check your verification mail", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(MainActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                }

            }
        });
        mAuth.signOut();





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




    private void sendVerificationEmail(FirebaseUser user )
    {
        gender = (RadioGroup) findViewById(R.id.gender);
        int selectedId = gender.getCheckedRadioButtonId();
        final RadioButton genderBtn = (RadioButton) findViewById(selectedId);
        fname = findViewById(R.id.fname);
        username = findViewById(R.id.username);
        mypassword = findViewById(R.id.password);
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
//                            // email sent
//
//
//                            // after email is sent just logout the user and finish this activity
//                            FirebaseAuth.getInstance().signOut();
////                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
//                            finish();


                            String uid = mAuth.getCurrentUser().getUid();

                            // find the radiobutton by returned id
//                            RadioGroup gender = (RadioGroup) findViewById(R.id.gender);
//                            RadioButton genderBtn = (RadioButton) findViewById(selectedId);
                            int userTypeId = 2;
                            boolean ismale = true;
                            if (genderBtn.getText().toString().equals("Female")) {
                                ismale = false;
                            }
//                            fname = findViewById(R.id.)
                            String name = fname.getText().toString();
                            String email = myemail.getText().toString();
                            String password = mypassword.getText().toString();
                            boolean emailVerified = false;

                            User mohamed = new User(uid, userTypeId, name, email, emailVerified, password, ismale);
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
                    Toast.makeText(MainActivity.this, "hello" , Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MainActivity.this, "done" , Toast.LENGTH_LONG).show();
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


        myRef= database.getReference().child("forms");
        myRef.push().setValue(new Form("second Form" , creatorId , departmentId , questions));
        myRef.push().setValue(new Form("third Form" , creatorId , departmentId , questions));
        myRef.push().setValue(new Form("fourth Form", creatorId , departmentId , questions));
        myRef.push().setValue(new Form("fifth Form" , creatorId , departmentId , questions));

    }

}