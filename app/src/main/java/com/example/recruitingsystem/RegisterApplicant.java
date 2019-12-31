package com.example.recruitingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import classes.Applicant;
import classes.Member;

public class RegisterApplicant extends AppCompatActivity {


    List<String> spinnerArray;
    List<Member> membersList;
    ArrayAdapter<String> adapter;

    DatabaseReference FreeSlotsRef,InterviewRef,MemberRef,ApplicantRef;

    EditText UniID,NameField,EmailField,MobileField,FromField,ToField,DateField;
    RadioGroup Gender_Grp;
    RadioButton Gender;
    Spinner AdrsSpinner,CommitteeSpinner,FacultySpinner;
    private String TAG = "RegisterApplicant";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_applicant);

        UniID=findViewById(R.id.UniIDField);
        NameField=findViewById(R.id.NameField);
        EmailField=findViewById(R.id.EmailField);
        MobileField=findViewById(R.id.MobileField);
        FromField=findViewById(R.id.FromField);
        ToField=findViewById(R.id.ToField);
        DateField=findViewById(R.id.DateField);

        Gender_Grp=findViewById(R.id.Gender_Grp);

        AdrsSpinner=findViewById(R.id.AdrsSpinner);
        CommitteeSpinner=findViewById(R.id.CommitteeSpinner);
        FacultySpinner=findViewById(R.id.FacSpinner);
    }

    //    private void checf_HR_availability()
//    {
////        DateField=findViewById(R.id.DateField);
//
//        spinnerArray=  new ArrayList<>();
//        membersList=  new ArrayList<>();
//
//        FreeSlotsRef= FirebaseDatabase.getInstance().getReference("FreeSlots");
//        InterviewRef= FirebaseDatabase.getInstance().getReference("Interview");
//        MemberRef= FirebaseDatabase.getInstance().getReference("Member");
//
//        // Read from the database
//        FreeSlotsRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot FreeSlot : dataSnapshot.getChildren()) {
//                    final FreeSlots freeSlots= FreeSlot.getValue(FreeSlots.class);
//
//                    InterviewRef.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            for (DataSnapshot Interview : dataSnapshot.getChildren()) {
//                                final Interview interview= Interview.getValue(Interview.class);
//
//                                if(interview.getMemberID().equals(freeSlots.getMemberID()) &&
//                                interview.getFreeSlotID().equals(freeSlots.ID) &&
//                                !interview.getDate().equals(DateField.getText().toString()))
//                                {
//                                    Log.v("If","Hey i'm in the Fucking if Condition");
//                                    MemberRef.addValueEventListener(new ValueEventListener() {
//                                        @Override
//                                        public void onDataChange(DataSnapshot dataSnapshot) {
//                                            Member member = dataSnapshot.child(interview.getMemberID()).getValue(Member.class);
//                                            Log.v("member",member.Name);
////                                            if (!membersList.isEmpty()) {
////                                                for (int i = 0; i < membersList.size(); i++) {
////                                                    if (!interview.getMemberID().equals(membersList.get(i).getID())) {
////                                                        membersList.add(member);
////                                                    }
////                                                }
////                                            }
////                                            else membersList.add(member);
//                                        }
//
//                                        @Override
//                                        public void onCancelled(DatabaseError error) {
//                                        }
//                                    });
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError error) {
//                        }
//                    });
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//            }
//        });
//        for(int i=0;i<membersList.size();i++) {
//            Log.v("spinner",membersList.get(i).getName());
//            spinnerArray.add(membersList.get(i).getName());
//        }
//
//        Toast.makeText(this,"Added Values",Toast.LENGTH_LONG).show();
//        adapter= new ArrayAdapter<String>(
//                this, android.R.layout.simple_spinner_item, spinnerArray);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Spinner sItems = findViewById(R.id.HRSpinner);
//        sItems.setAdapter(adapter);
//    }
    public void Register(View view)
    {
        Log.d(TAG, "Register: start");
        ApplicantRef=FirebaseDatabase.getInstance().getReference("Applicant");
        Log.d(TAG, "Register: 1");
        String id=ApplicantRef.push().getKey();
        Log.d(TAG, "Register: 2");

        int gender_id=Gender_Grp.getCheckedRadioButtonId();
        Log.d(TAG, "Register: 3");
        Gender=findViewById(gender_id);
        Log.d(TAG, "Register: 4");

        Applicant applicant=new Applicant(id, UniID.getText().toString(), NameField.getText().toString(),
                EmailField.getText().toString(),
                MobileField.getText().toString(),
                Gender.getText().toString(),
                AdrsSpinner.getSelectedItem().toString(),
                FacultySpinner.getSelectedItem().toString(),
                CommitteeSpinner.getSelectedItem().toString(),
                FromField.getText().toString(),
                ToField.getText().toString(),
                DateField.getText().toString());
        Log.d(TAG, "Register: 5");

        ApplicantRef.child(id).setValue(applicant);
        Log.d(TAG, "Register: 6");

        Intent intent=new Intent(this,SendMail.class);
        Log.d(TAG, "Register: 7");
        intent.putExtra("Email",EmailField.getText().toString());
        Log.d(TAG, "Register: 8");
        intent.putExtra("Date",DateField.getText().toString());
        Log.d(TAG, "Register: 9");
        intent.putExtra("From",FromField.getText().toString());
        Log.d(TAG, "Register: 10");
        intent.putExtra("To",ToField.getText().toString());
        Log.d(TAG, "Register: 11");
        startActivity(intent);
        Log.d(TAG, "Register: end");
    }
}
