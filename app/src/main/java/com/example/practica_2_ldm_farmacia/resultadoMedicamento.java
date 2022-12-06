package com.example.practica_2_ldm_farmacia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultadoMedicamento extends AppCompatActivity {
    //Inicializamos las variables del medicamento a enseñar.
    private String codigo,nombre,descripcion,precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_medicamento);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D7214")));
        this.setTitle(R.string.mi_titulo);
        //Recogemos los valores de la activity anterior
        this.codigo      = (String) getIntent().getExtras().getString("codigo");
        this.nombre      = (String) getIntent().getExtras().getString("nombre");
        this.descripcion = (String) getIntent().getExtras().getString("descripcion");
        this.precio      = (String) getIntent().getExtras().getString("precio");

        TextView cod = findViewById(R.id.codigoTEXTVIEW);
        cod.setText(this.codigo);

        cod = findViewById(R.id.textviewNombre2);
        cod.setText(this.nombre);

        cod = findViewById(R.id.descripcionTEXTVIEW2);
        cod.setText(this.descripcion);

        cod = findViewById(R.id.precioTEXTVIEW);
        cod.setText(this.precio);

    }


    public void mainActivity(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}