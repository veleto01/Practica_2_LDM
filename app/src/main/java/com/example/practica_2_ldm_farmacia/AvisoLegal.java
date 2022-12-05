package com.example.practica_2_ldm_farmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AvisoLegal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso_legal);
    }

    public void AvisoLegal(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}