package com.android.online.voteapp;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class pres extends AppCompatActivity {

    TextView finalresult;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pres);
        finalresult = (TextView) findViewById(R.id.resulttext);
        finalresult.setEnabled(false);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference();
    }
    public void SelectPres(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId())
        {
            case R.id.rb1:
                if(checked) {
                    finalresult.setText("Sabul Ian");
                    finalresult.setEnabled(true);
                }
                else
                {
                    finalresult.setEnabled(false);
                }
                break;
            case R.id.rb2:
                if(checked) {
                    finalresult.setText("John Theuri");
                    finalresult.setEnabled(true);
                }
                else
                {
                    finalresult.setEnabled(false);
                }
                break;

        }
    }
    public void sendvote(View view){
        String n = finalresult.getText().toString();
        if (n == "Sabul Ian") {

            databaseReference.child("Sabul Ian").push().setValue(n);
        }
        else{
            databaseReference.child("John Theuri").push().setValue(n);
        }
        Intent startnew = new Intent(this,gov.class);
        startActivity(startnew);
    }
}
