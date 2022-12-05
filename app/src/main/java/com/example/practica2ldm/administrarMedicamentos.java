package com.example.practica2ldm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica2ldm.db.dbMedicamentos;

public class administrarMedicamentos extends AppCompatActivity {

    EditText idMedicamento, nombreMedicamento, precioMedicamento;

    Button botonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_medicamentos);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D7214")));
        this.setTitle(R.string.mi_titulo);

        idMedicamento = findViewById(R.id.editTextID);
        nombreMedicamento = findViewById(R.id.editTextNombre);
        precioMedicamento = findViewById(R.id.editTextPrecio);
    }


    public void Registrar(View view) {
        if(!idMedicamento.getText().toString().equals("") && !nombreMedicamento.getText().toString().equals("")&& !precioMedicamento.getText().toString().equals("")) {

            dbMedicamentos dbMedicamentos = new dbMedicamentos(administrarMedicamentos.this);
            long id = dbMedicamentos.insertarMedicamento(idMedicamento.getText().toString(),nombreMedicamento.getText().toString(),precioMedicamento.getText().toString());
            if (id > 0) {
                Toast.makeText(administrarMedicamentos.this, "MEDICAMENTO GUARDADO", Toast.LENGTH_LONG).show();
                limpiar();
            } else {
                Toast.makeText(administrarMedicamentos.this, "ERROR AL GUARDAR", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(administrarMedicamentos.this, "DEBE LLENAR TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
        }
    }


    private void limpiar() {
        idMedicamento.setText("");
        nombreMedicamento.setText("");
        precioMedicamento.setText("");
    }


}