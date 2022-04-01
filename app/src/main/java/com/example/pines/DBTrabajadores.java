package com.example.pines;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBTrabajadores {

    Context context;
    Trabajador trabajador;
    ArrayList<Trabajador> listaTrabajadores;
    SQLiteDatabase sqLiteDatabase;
    String bd = "BDPines";
    String tablaTrabajadores = "CREATE TABLE IF NOT EXISTS trabajador(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT ," +
            "apellido TEXT ," +
            "documento TEXT ," +
            "correo TEXT ," +
            "saldo TEXT ," +
            "nombre_usuario TEXT ," +
            "contrasena TEXT )";

    public DBTrabajadores(Context context) {
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(bd, Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL(tablaTrabajadores);
        trabajador = new Trabajador();

    }

    public boolean insertarTrabajador(Trabajador trabajador) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nombre", trabajador.getNombre());
            contentValues.put("apellido", trabajador.getApellido());
            contentValues.put("documento", trabajador.getDocumento());
            contentValues.put("correo", trabajador.getCorreo());
            contentValues.put("nombre_usuario", trabajador.getNombreUsuario());
            contentValues.put("contrasena", trabajador.getContrasena());
            contentValues.put("saldo", trabajador.getSaldo());
            sqLiteDatabase.insert("trabajador",null,contentValues);
            return true;
    }

    public ArrayList<Trabajador> selecionarUsuario(){
        ArrayList<Trabajador> listaTrabajadores=new ArrayList<Trabajador>();
        listaTrabajadores.clear();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM trabajador",null);
        if(cursor!=null&&cursor.moveToFirst()){
            do {
                Trabajador trabajador= new Trabajador();
                trabajador.setId(cursor.getInt(0));
                trabajador.setNombre(cursor.getString(1));
                trabajador.setApellido(cursor.getString(2));
                trabajador.setDocumento(cursor.getString(3));
                trabajador.setCorreo(cursor.getString(4));
                trabajador.setNombreUsuario(cursor.getString(5));
                trabajador.setContrasena(cursor.getString(6));
                trabajador.setSaldo(cursor.getString(7));
                listaTrabajadores.add(trabajador);
            }while (cursor.moveToNext());

        }return listaTrabajadores;
    }


    public int login(String nombreUsuario, String contrasena){
        int a=0;
        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM trabajador", null)) {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    if (cursor.getString(5).equals(nombreUsuario) && cursor.getString(6).equals(contrasena)) {
                        a++;
                    }
                } while (cursor.moveToNext());
            }
        }
        return a;
    }


    public Trabajador getTrabajador(String nombreUsuario,String contrasena) {
        listaTrabajadores = selecionarUsuario();
        for(Trabajador trabajador:listaTrabajadores){
            if(trabajador.getNombreUsuario().equals(nombreUsuario)&&trabajador.getContrasena().equals(contrasena)){
                return trabajador;
            }
        }
        return null;
    }

    public Trabajador getTrabajadorById(int id) {
        listaTrabajadores = selecionarUsuario();
        for(Trabajador trabajador:listaTrabajadores){
            if(trabajador.getId()==id){
                return trabajador;
            }

        }
        return null;
    }

}
