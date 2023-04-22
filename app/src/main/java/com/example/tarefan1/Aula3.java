package com.example.tarefan1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.example.tarefan1.repositories.UserRepository;
import com.example.tarefan1.services.ServiceDone;
import com.example.tarefan1.services.UserService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Aula3 extends AppCompatActivity {
    private List<user> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula3);
        Button btn2 = findViewById(R.id.btnJsonTela3);
        btn2.setOnClickListener(view->{
            getAllUsers();
        });
    }

    public void onVoltarb(View view){
        Intent in = new Intent(Aula3.this, MainActivity.class);
        startActivity(in);
    }

    private void getAllUsers(){
        UserService.getAllUsers(this, ()->{System.out.println(UserRepository.getInstance().getUsers());});
    }
}