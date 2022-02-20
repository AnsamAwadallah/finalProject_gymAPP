package com.example.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private EditText etfname , etlname,etEmail, etPassword,etdate;
    private String fname , lname ,email, password,date,gender;
    private TextView tvStatus;
    private Button btnRegister;
    private Spinner sgender;
    private String URL = "http://10.0.2.2/login/register.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etfname = findViewById(R.id.etfname);
        etlname = findViewById(R.id.etlname);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etdate = findViewById(R.id.etdate);
        sgender = findViewById(R.id.sgender);

        tvStatus = findViewById(R.id.tvStatus);
        btnRegister = findViewById(R.id.btnRegister);

        addToSpinner();
        fname = lname = email = password = date = gender= "";
    }

    private void addToSpinner(){
        String[] arraySpinner = new String[] {
                "Male", "Female"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sgender.setAdapter(adapter);
    }
    public void save(View view) {
        fname = etfname.getText().toString().trim();
        lname = etfname.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        date = etdate.getText().toString().trim();

        gender=sgender.getSelectedItem().toString().trim();

//        if(!password.equals(reenterPassword)){
//            Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
//        }else
        if(!fname.equals("") && !lname.equals("")&& !email.equals("") && !password.equals("")&&!date.equals("")&&!gender.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                    response -> {
                        Toast.makeText(this,  email + password, Toast.LENGTH_SHORT).show();

                        if (response.equals("success")) {
//                            Toast.makeText(this, "SSSSSSSS", Toast.LENGTH_SHORT).show();
                            tvStatus.setText("Successfully registered.");
                            btnRegister.setClickable(false);
                        } else if (response.equals("failure")) {

                            tvStatus.setText("Something went wrong!");                    }
                    }, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show()){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("fname", fname);
                    data.put("lname",lname);
                    data.put("email", email);
                    data.put("password", password);
                    data.put("date", date);
                    data.put("gender", gender);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

    public void login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
