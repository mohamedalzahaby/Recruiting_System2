package com.example.recruitingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendMail extends AppCompatActivity {

    EditText mailSender,mailSubject;
    Bundle b;
    String Email,Date,From,To,Body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        mailSender=findViewById(R.id.mailSender);
        mailSubject=findViewById(R.id.mailSubject);

        b=getIntent().getExtras();
        Email=b.getString("Email");

        Date=b.getString("Date");
        From=b.getString("From");
        To=b.getString("To");

        Body="Your interview time is on "+Date+" at "+From+'-'+To;



    }
    public void sendMail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, mailSender.getText().toString());
        intent.putExtra(Intent.EXTRA_EMAIL,new String[] { Email });
        intent.putExtra(Intent.EXTRA_SUBJECT, mailSubject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, Body);
        startActivity(intent);
    }
}
