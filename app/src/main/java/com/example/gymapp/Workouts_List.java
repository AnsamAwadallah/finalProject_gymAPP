package com.example.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Workouts_List extends AppCompatActivity {
    String email;

    ListView lstt;
    ArrayList<Work> works = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutslist);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        lstt = findViewById(R.id.lst);
        getlist();
    }

    private void getlist() {
            String url = "http://localhost/login/membersList.php?email="+email;

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url,
                            null, response -> {

                                String[] works;
                                try {
                                    JSONArray array = response.getJSONArray("0");
                                    works = new String[array.length()];
                                    for(int i = 0; i<array.length(); i++){
                                        JSONObject obj = array.getJSONObject(i);
                                        String work = "";
                                        work = "wourkoutname : " + obj.getString("wourkoutname") +
                                                "\n, useremail : " + obj.getString("useremail") +
                                                "\n, wourkoutDate: " + obj.getString("wourkoutDate");
                                        works[i] = work;
                                    }
                                    ArrayAdapter<String> itemsAdapter =
                                            new ArrayAdapter<String>(Workouts_List.this, android.R.layout.simple_list_item_1,
                                                    works);
                                    lstt.setAdapter(itemsAdapter);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }, error -> {
                                // TODO: Handle error

                            });
            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        }


    private void getlist1() {
        String url = "http://localhost/login/membersList.php?email="+email;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array

                                JSONObject obj = array.getJSONObject(i);

                                String wourkoutname = (String) obj.get("wourkoutname");
                                String useremail = (String) obj.get("useremail");
                                String wourkoutDate= (String) obj.get("wourkoutDate");

                                Work f=new Work(wourkoutname,useremail,wourkoutDate);
                                works.add(f);
                            }

                            Work.works =works;
                            //creating adapter object and setting it to recyclerview

                            ArrayAdapter<Work> itemsAdapter =new ArrayAdapter<Work>( Workouts_List.this, android.R.layout.simple_list_item_1,
                                    works);
                            lstt.setAdapter(itemsAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);



    }
        


}