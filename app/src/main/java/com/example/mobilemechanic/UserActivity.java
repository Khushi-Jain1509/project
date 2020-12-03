package com.example.mobilemechanic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    EditText userName,userPhoneNumber,userEmail;
    Button nextButton;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Boolean firstTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        pref= getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        firstTime=pref.getBoolean("First Time",true);
        if(!firstTime){
            Intent i=new Intent(UserActivity.this,VehicleActivity.class);
            editor.putBoolean("First Time",false);
            editor.commit();
            startActivity(i);
        }
        findView();
    }

    public void findView(){
        userName = findViewById(R.id.userName);
        userPhoneNumber = findViewById(R.id.userPhoneNumber);
        userEmail = findViewById(R.id.userEmail);
        nextButton=findViewById(R.id.nextButton);
    }

    public void onClickingNext(View view){
        if(!userName.getText().toString().isEmpty() && !userPhoneNumber.getText().toString().isEmpty() && !userEmail.getText().toString().isEmpty()){
            Intent i=new Intent(UserActivity.this,VehicleActivity.class);
            editor.putBoolean("First Time",false);
            editor.commit();
            startActivity(i);
        }else{
            Toast.makeText(getApplicationContext(),"Please fill all the feilds", Toast.LENGTH_SHORT).show();
        }
    }




}