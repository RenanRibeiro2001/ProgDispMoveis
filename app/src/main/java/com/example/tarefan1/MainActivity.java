package com.example.tarefan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAula1(View view){
        Intent in = new Intent(MainActivity.this, Aula1.class);
        startActivity(in);
    }

    public void onAula2(View view){
        Intent in = new Intent(MainActivity.this, Aula2.class);
        startActivity(in);
    }

    public void onAula3(View view){
        Intent in = new Intent(MainActivity.this, Aula3.class);
        startActivity(in);
    }

    public void onAula4(View view) {
        Intent in = new Intent(MainActivity.this, Aula4.class);
        startActivity(in);
    }

    public void onAula5(View view) {
        Intent in = new Intent(MainActivity.this, Aula5.class);
        startActivity(in);
    }
}