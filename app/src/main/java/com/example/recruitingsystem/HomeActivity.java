package com.example.recruitingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String userTypeId = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);





    }
}
