package com.example.recruitingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import classes.Member;

public class AddMember extends AppCompatActivity {

    Spinner AdrsSpinner,FacSpinner,CommitteeSpinner;

    EditText UniID,Name,Email,Mobile,Adrs,Faculty,Committee;

    RadioGroup Gender_Grp;
    RadioButton Gender;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        ref= FirebaseDatabase.getInstance().getReference("Member");

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        AdrsSpinner = findViewById(R.id.AdrsSpinner);
        FacSpinner = findViewById(R.id.FacSpinner);
        CommitteeSpinner = findViewById(R.id.CommitteeSpinner);
    }

    public void AddMember(View view) {
        UniID=findViewById(R.id.UniIDField);
        Name=findViewById(R.id.NameField);
        Email=findViewById(R.id.EmailField);
        Mobile=findViewById(R.id.MobileField);
        Gender_Grp=findViewById(R.id.Gender_Grp);
        int gender_id=Gender_Grp.getCheckedRadioButtonId();
        Gender=findViewById(gender_id);

        String uni_id=UniID.getText().toString();
        String name=Name.getText().toString();
        String email=Email.getText().toString();
        String mobile=Mobile.getText().toString();
        String adrs=AdrsSpinner.getSelectedItem().toString();
        String fac=FacSpinner.getSelectedItem().toString();
        String com=CommitteeSpinner.getSelectedItem().toString();
        String gender=Gender.getText().toString();

        String id=ref.push().getKey();
        Member member=new Member(id,com,adrs,gender,fac,name,mobile,uni_id,email);
        ref.child(id).setValue(member);
    }
}
