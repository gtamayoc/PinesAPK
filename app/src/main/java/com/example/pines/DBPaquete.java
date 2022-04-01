package com.example.pines;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;


public class DBPaquete {
    Context context;
    Trabajador trabajador;
    ArrayList<paquete> listaPaquetes;
    SQLiteDatabase sqLiteDatabase;
    String bd = "BDPines";
    String tablaPaquetes = "CREATE TABLE IF NOT EXISTS paquete(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT ," +
            "descripcion TEXT ," +
            "plan_disponible TEXT )";

    public DBPaquete(Context context) {
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(bd, Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL(tablaPaquetes);
        trabajador = new Trabajador();

    }

    public boolean insertarTrabajador(Trabajador trabajador) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", trabajador.getNombre());
        contentValues.put("descripcion", trabajador.getApellido());
        contentValues.put("plan_disponible", trabajador.getDocumento());
        sqLiteDatabase.insert("paquete", null, contentValues);
        return true;
    }

}
