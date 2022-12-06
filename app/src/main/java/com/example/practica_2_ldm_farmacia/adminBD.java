package com.example.practica_2_ldm_farmacia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminBD extends AppCompatActivity {

    //MediaPlayer
    MediaPlayer sonido;

    //Inicializamos los botones para el sonido
    Button EliminarButton;
    Button RegistrarButton;
    Button ModificarButton;

    //EditText
    EditText EditCodigo,EditNombre,EditDescripcion,EditPrecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_bd);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D7214")));
        this.setTitle(R.string.mi_titulo);
        //Inicializamos los edittext
        EditCodigo = findViewById(R.id.codigo_EditText);
        EditNombre = findViewById(R.id.nombre_EditText);
        EditDescripcion = findViewById(R.id.Descripcion_EditText);
        EditPrecio = findViewById(R.id.precio_EditText);

        EliminarButton = (Button) findViewById(R.id.eliminarButton);
        RegistrarButton = (Button) findViewById(R.id.registrarButton);
        ModificarButton = (Button) findViewById(R.id.modificarButton);
    }

    public void Eliminar(View view){
        //Inicializamos el manejador de la base de datos
        dbHelper bd = new dbHelper(this,"farmacia_bd",null,1);
        SQLiteDatabase ADMIN = bd.getWritableDatabase();
        //Filtraremos por el codigo, ya que es unico y no por ningún otro campo.
        //Necesario cambiarlo a String para poder operar con el.
        String Codigo = EditCodigo.getText().toString();
        if (!Codigo.isEmpty()){
            //Trateremos si se ha eliminado comprobando lo que devuelve la funcion .delete()
            int comprobacion = ADMIN.delete("medicamentos","codigo=" + Codigo,null);
            //Cerramos la base de datos.
            ADMIN.close();
            //Limpiaremos los cuadros de texto.
            limpiar();
            //Comprobaremos el valor de la variable comprobación
            if(comprobacion == 1){
                Toast.makeText(this, "El medicamento ha sido eliminado", Toast.LENGTH_SHORT).show();
                sonido = MediaPlayer.create(this,R.raw.sonidobien);
                sonido.start();
            }else{
                Toast.makeText(this, "El medicamento no ha podido ser eliminado", Toast.LENGTH_SHORT).show();
                sonido = MediaPlayer.create(this,R.raw.botonmal);
                sonido.start();
            }
        }else{
            Toast.makeText(this, "No has introducido código", Toast.LENGTH_SHORT).show();
        }
    }
    public void Modificar(View view){
        //Inicializamos el manejador de la base de datos
        dbHelper bd = new dbHelper(this,"farmacia_bd",null,1);
        SQLiteDatabase ADMIN = bd.getWritableDatabase();
        //Inicializamos todos los cuadros de texto para poder recogerlos y modificarlos en la base de datos.
        String nombre = EditNombre.getText().toString();
        String Codigo = EditCodigo.getText().toString();
        String Descripcion = EditDescripcion.getText().toString();
        String Precio = EditPrecio.getText().toString();
        //Filtraremos que campos son necesarios para poder insertar a la base de datos.
        //En este caso solo hará falta El codigo la descripcion y el precio
        if(!Codigo.isEmpty() && !Descripcion.isEmpty() && !Precio.isEmpty()){
            //Inicializamos el puntero de la tabla con la clase ContentValues para poder ir iterando con ella
            ContentValues puntero = new ContentValues();
            puntero.put("codigo",Codigo);
            puntero.put("nombre",nombre);
            puntero.put("descripcion",Descripcion);
            puntero.put("precio",Precio);

            //Trateremos si se ha modificado comprobando lo que devuelve la funcion .update()
            long comprobacion = ADMIN.update("medicamentos",puntero,"codigo" + Codigo,null);
            //Cerraremos la base de datos.
            ADMIN.close();
            //Limpiaremos los cuadros de texto.
            limpiar();
            //Comprobaremos el valor de la variable comprobación
            if(comprobacion== 1 ){
                Toast.makeText(this, "El medicamento ha sido modificado correctamente", Toast.LENGTH_LONG).show();
                sonido = MediaPlayer.create(this,R.raw.sonidobien);
                sonido.start();
            }else{
                Toast.makeText(this, "El medicamento no existe ", Toast.LENGTH_SHORT).show();
                sonido = MediaPlayer.create(this,R.raw.botonmal);
                sonido.start();
            }
        }else{
            Toast.makeText(this, "Faltan campos obligatarios", Toast.LENGTH_SHORT).show();
        }
    }
    public void Registrar(View view){
        //Inicializamos el manejador de la base de datos
        dbHelper bd = new dbHelper(this,"farmacia_bd",null,1);
        SQLiteDatabase ADMIN = bd.getWritableDatabase();
        //Inicializamos todos los cuadros de texto para poder recogerlos e insertalos en la base de datos.
        String nombre = EditNombre.getText().toString();
        String Codigo = EditCodigo.getText().toString();
        String Descripcion = EditDescripcion.getText().toString();
        String Precio = EditPrecio.getText().toString();

        //Filtraremos que campos son necesarios para poder insertar a la base de datos.
        //En este caso solo hará falta El codigo la descripcion y el precio
        if(!Codigo.isEmpty() && !nombre.isEmpty() && !Precio.isEmpty()){
            //Inicializamos el puntero de la tabla con la clase ContentValues para poder ir iterando con ella
            ContentValues puntero = new ContentValues();
            puntero.put("codigo",Codigo);
            puntero.put("nombre",nombre);
            puntero.put("descripcion",Descripcion);
            puntero.put("precio",Precio);

            //Trateremos si se ha añadido comprobando lo que devuelve la funcion .insert()
            long comprobacion = ADMIN.insert("medicamentos",null,puntero);
            //Cerraremos la base de datos.
            ADMIN.close();
            //Limpiaremos los cuadros de texto.
            limpiar();
            //Comprobaremos el valor de la variable comprobación
            if(comprobacion== -1 ){
                Toast.makeText(this, "El medicamento ya existe o se ha puesto  mal algun dato", Toast.LENGTH_LONG).show();
                sonido = MediaPlayer.create(this,R.raw.botonmal);
                sonido.start();


            }else{
                Toast.makeText(this, "Medicamento registrado correctamente ", Toast.LENGTH_SHORT).show();
                sonido = MediaPlayer.create(this,R.raw.sonidobien);
                sonido.start();
            }
        }else{
            Toast.makeText(this, "Faltan campos obligatarios", Toast.LENGTH_SHORT).show();
            sonido = MediaPlayer.create(this,R.raw.botonmal);
            sonido.start();
        }
    }
    public void limpiar(){
        EditCodigo.setText("");
        EditNombre.setText("");
        EditDescripcion.setText("");
        EditPrecio.setText("");
    }

}