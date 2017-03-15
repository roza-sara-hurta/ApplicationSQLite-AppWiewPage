package com.example.carlos_arriaga.applicationsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Carlos_Arriaga on 28/02/2017.
 */

public class SQLControlador {
    private DBhelper dBhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador (Context ourcontext){
        this.ourcontext = ourcontext;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException{
        dBhelper = new DBhelper(ourcontext);
        database=dBhelper.getWritableDatabase();
        return this;
    }

    public void cerrar(){
        dBhelper.close();
    }

    public void insertarDatos(String name){
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.MEMBER_NOMBRE, name);
        database.insert(DBhelper.TABLE_MEMBER,null,cv);
    }

    public void deleteData(long memberID){
        database.delete(DBhelper.TABLE_MEMBER, DBhelper.MEMBER_ID+"="+memberID,null);
    }

    public int actualizarDatos(long memberID, String memberName){
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.MEMBER_NOMBRE, memberName);
        int i = database.update(DBhelper.TABLE_MEMBER, cvActualizar,
                DBhelper.MEMBER_ID+" = " + memberID, null);
        return i;
    }

    public Cursor leerDatos(){
        String[] todasLasColumnas = new String[]{
                DBhelper.MEMBER_ID,
                DBhelper.MEMBER_NOMBRE
        };
        Cursor c = database.query(DBhelper.TABLE_MEMBER, todasLasColumnas,
                null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }
}
