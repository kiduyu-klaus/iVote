package com.android.online.voteapp;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class gov extends AppCompatActivity {

    TextView result;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gov);
        result = (TextView) findViewById(R.id.resulttxt);
        result.setEnabled(false);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public void select(View view){
        boolean check = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb9:
                if(check){
                    result.setText("Mercy Cheptoo");
                    result.setEnabled(true);
                }
                else{
                    result.setEnabled(false);
                }
                break;
            case R.id.rb10:
                if(check){
                    result.setText("Mike Omondi");
                    result.setEnabled(true);
                }
                else {
                    result.setEnabled(false);
                }
                break;
        }


    }
    public void finalbtn(View view){
        String y = result.getText().toString();
        if(y == "Mercy Cheptoo"){
            databaseReference.child("Mercy Cheptoo").push().setValue(y);
        }
        else
        {
            databaseReference.child("Mike Omondi").push().setValue(y);
        }
        Intent finalact = new Intent(this,success.class);
        startActivity(finalact);
    }
}
