package com.example.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Member_Home extends AppCompatActivity {
   Button BMI;
   TextView tvemail;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        tvemail = findViewById(R.id.tvemail);
        tvemail.setText(email);


    }

    public void onClickBMI(View view) {
        Intent intent2= new Intent(Member_Home.this , BMI.class);
        startActivity(intent2);
    }

    public void onClickworkouts(View view) {
        Intent intent2= new Intent(Member_Home.this , Workouts_List.class);
        intent2.putExtra("email",email);
        startActivity(intent2);

    }

    public void onClicknutriton(View view) {
    }

    public void logout(View view) {
        Intent intent= new Intent(Member_Home.this , Login.class);
        startActivity(intent);

    }
}