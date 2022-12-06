package com.example.practica_2_ldm_farmacia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class buscarMedicamento extends AppCompatActivity {
    //Inicializamos el EditText
    EditText nombreBuscar;
    //Inicializamos las variables del producto que vamos a buscar
    private String codigoMedicamento;
    private String descripcionMedicamento;
    private String precioMedicamento;
    private String nombreMedicamento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_medicamento);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D7214")));
        this.setTitle(R.string.mi_titulo);
        //Inicializamos el edit text con el creado en el codigo para poder tratarlo.
        nombreBuscar = (EditText) findViewById(R.id.nombreABuscarPlainText);
    }

    public void buscar(View view){
        //Inicializamos el manejador de la base de datos
        dbHelper bd = new dbHelper(this,"farmacia_bd",null,1);
        SQLiteDatabase ADMIN = bd.getReadableDatabase();

        //Filtraremos por el nombre del medicamento.
        String nombreABuscar = nombreBuscar.getText().toString();

        if(!nombreABuscar.isEmpty()){
            String[] campos = {"codigo","nombre","descripcion","precio"};
            //Inicializamos el cursor que buscará por la base de datos
            Cursor cursor = ADMIN.rawQuery("select * from medicamentos where nombre='"+nombreABuscar+"'",null);
            //Con un try, nos encargamos de la gestion de errores por si no hubiera elemento en la tabla
            try{
                cursor.moveToFirst();
                this.codigoMedicamento      = cursor.getString(0);
                this.nombreMedicamento = cursor.getString(1);
                this.descripcionMedicamento = cursor.getString(2);
                this.precioMedicamento      = cursor.getString(3);
                //Cerraremos la base de datos
                ADMIN.close();
                //Pasaremos de Activity una vez hayamos encontrado el medicamento
                Intent intent = new Intent(this,resultadoMedicamento.class);
                intent.putExtra("codigo",this.codigoMedicamento);
                intent.putExtra("nombre", this.nombreMedicamento);
                intent.putExtra("descripcion",this.descripcionMedicamento);
                intent.putExtra("precio",this.precioMedicamento);
                startActivity(intent);

            } catch (Exception e) {
                Toast.makeText(this, "Este producto no existe", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "No has escrito nada", Toast.LENGTH_SHORT).show();
        }
    }
}