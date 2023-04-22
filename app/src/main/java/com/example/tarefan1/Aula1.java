package com.example.tarefan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tarefan1.models.user;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Aula1 extends AppCompatActivity  {

    private EditText edit1;
    private EditText edit2;
    private EditText edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula1);
    }

    public void onVoltar (View view) {
        Intent in = new Intent(Aula1.this, MainActivity.class);
        startActivity(in);
    }

    public void onJson (View view){
    doRequest();
    }

    protected void doRequest() {
        String url = "https://jsonplaceholder.typicode.com/users/3";

        edit1 = findViewById(R.id.name);
        edit2 = findViewById(R.id.userName);
        edit3 = findViewById(R.id.email);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //System.out.println(response);
                        user User;
                        try {
                            User = new user (
                            response.getInt("id"),
                            response.getString("name"),
                            response.getString("username"),
                            response.getString("email"));

                            edit1.setText(User.getName());
                            edit2.setText(User.getUserName());
                            edit3.setText(User.getEmail());

                        } catch (JSONException e) {
                            System.out.println("Erro no Json !!" + e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}