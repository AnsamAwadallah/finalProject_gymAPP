package com.example.gymapp;

import static com.example.gymapp.R.layout.activity_employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Employee_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_employee);
    }

    public void onClickmembership(View view) {
        Intent intent2= new Intent(Employee_Home.this , Members_list.class);
        startActivity(intent2);

    }
    public void logout(View view) {
        Intent intent= new Intent(Employee_Home.this , Login.class);
        startActivity(intent);

    }
    public void onClickBMI(View view) {
        Intent intent2= new Intent(Employee_Home.this , BMI.class);
        startActivity(intent2);
    }
}