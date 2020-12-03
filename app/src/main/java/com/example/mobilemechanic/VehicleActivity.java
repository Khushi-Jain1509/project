package com.example.mobilemechanic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VehicleActivity extends AppCompatActivity {
    EditText carCompany,carModel,carProblem;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        findId();
    }

    public void findId(){
        carCompany=findViewById(R.id.carCompany);
        carModel=findViewById(R.id.carModelName);
        carProblem=findViewById(R.id.carProblem);
        nextButton=findViewById(R.id.nextButton);
    }

    public void onClickingNext(View view){
        Intent i= new Intent(VehicleActivity.this,MechanicListActivity.class);
        startActivity(i);
    }
}