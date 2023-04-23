package com.example.tarefan1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tarefan1.adapters.UsersAdapter;
import com.example.tarefan1.models.user;
import com.example.tarefan1.repositories.UserRepository;
import com.example.tarefan1.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class Aula4 extends AppCompatActivity {

    private List<user> users = new ArrayList<>();
    private RecyclerView rv;
    LinearLayoutManager llm;
    LinearLayoutManager llmh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula4);
        llm = new LinearLayoutManager(this);
        llmh = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rv = findViewById(R.id.UsersRv);
        Button btn3 = findViewById(R.id.btnArray);
        btn3.setOnClickListener(view->{
            getAllUsers();
        });
        findViewById(R.id.btnTrocar).setOnClickListener((v) -> {
            if (rv.getLayoutManager() == llm){
                rv.setLayoutManager(llmh);
            }
            else {
             rv.setLayoutManager(llm);
            }
        });
    }


    public void onVoltarc(View view){
        Intent in = new Intent(Aula4.this, MainActivity.class);
        startActivity(in);
    }

    private void getAllUsers(){
        UserService.getAllUsers(this, ()->{
            UsersAdapter adapter = new UsersAdapter(new ArrayList(UserRepository.getInstance().getUsers()));
            rv.setLayoutManager(llmh);
            rv.setAdapter(adapter);
        });
    }
}