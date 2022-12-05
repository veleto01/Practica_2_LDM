package com.example.practica_2_ldm_farmacia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase miBBDD) {
        miBBDD.execSQL("create table medicamentos(" +
                "codigo INTEGER primary key," +
                "nombre TEXT, " +
                "descripcion TEXT, " +
                "precio INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
    }
}
