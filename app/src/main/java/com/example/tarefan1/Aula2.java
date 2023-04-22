package com.example.tarefan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tarefan1.models.user;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Aula2 extends AppCompatActivity  implements Response.Listener<JSONArray>, Response.ErrorListener {
    private List<user> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula2);
        Button btn = findViewById(R.id.btnJsonArray);
        btn.setOnClickListener(view->{
            getAllUsers();
        });
    }

    public void onVoltarA(View view){
        Intent in = new Intent(Aula2.this, MainActivity.class);
        startActivity(in);
    }

    private void getAllUsers(){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users", null, this, this);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Ocorreu uma falha na requisicao" + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        for(int i = 0; i < response.length(); i++){
            //System.out.println(response);
            user User;
            try {
            JSONObject json = response.getJSONObject(i);
                User = new user (
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("username"),
                        json.getString("email"));
                users.add(User);
            } catch (JSONException e) {
                System.out.println("Erro no Json !!" + e.getMessage());
            }
        }
        System.out.println(users);
    }
}