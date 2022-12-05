package com.example.practica2ldm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    public static final String DATABASE_NOMBRE="Farmacia.db";
    public static final String TABLE_MEDICAMENTOS="Medicamentos";
    public dbHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MEDICAMENTOS + "(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nombre TEXT NOT NULL, " +
                " precio INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLE_MEDICAMENTOS);
        onCreate(db);
    }
}
