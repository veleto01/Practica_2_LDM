package com.example.practica2ldm.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class dbMedicamentos extends dbHelper{

    Context context;

    public dbMedicamentos(Context context) {
        super(context);
        this.context=context;
    }

    public long insertarMedicamento(String idMecicamento, String Nombre, String precio){
        long id =0;
        try{
            dbHelper dbHelper = new dbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id",idMecicamento);
            values.put("nombre",Nombre);
            values.put("precio",precio);

            id = db.insert(TABLE_MEDICAMENTOS,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
