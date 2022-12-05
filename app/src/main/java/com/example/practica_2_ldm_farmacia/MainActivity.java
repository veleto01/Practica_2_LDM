package com.example.practica_2_ldm_farmacia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D7214")));
        this.setTitle(R.string.mi_titulo);
    }

    public void AvisoLegal(View view){
        Intent intent = new Intent(this,AvisoLegal.class);
        startActivity(intent);
    }

    public void Admin(View view){
        Intent intent = new Intent(this,adminBD.class);
        startActivity(intent);
    }

}