package com.example.gymapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMI extends AppCompatActivity {
    public static final String Height="Height";
    public static final String Weight="Weight";

    private EditText editHeight;
    private EditText editWeight;
    private TextView bmiCalc;

    public BMI() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        editHeight=findViewById(R.id.Height);
        editWeight=findViewById(R.id.Weight);
        bmiCalc=findViewById(R.id.bmiCalc);

    }
    public void onClickcalculat(View view) {

        String weight =editWeight.getText().toString();
        String height=editHeight.getText().toString();

        //bmi calculate
        double kg= Double.valueOf(weight);
        double m= Double.valueOf(height)/100;
        double bmi=kg/(m*m);

        bmiCalc.setText(""+ bmi);


    }

}
