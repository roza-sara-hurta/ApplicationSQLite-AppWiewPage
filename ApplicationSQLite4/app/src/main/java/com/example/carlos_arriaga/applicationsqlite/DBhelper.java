package com.example.carlos_arriaga.applicationsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBhelper extends SQLiteOpenHelper{

    //INFORMACION DE LA TABLA
    public static final String TABLE_MEMBER = "miembros";
    public static final String MEMBER_ID="_id";
    public static final String MEMBER_NOMBRE= "nombre";

    //información de la base de datos

    static final String DB_NAME = "DBMIEMBRO";
    static final int DB_VERSION= 1;

    private static final String CREATE_TABLE="create table "
            +TABLE_MEMBER +" ("+MEMBER_ID
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +MEMBER_NOMBRE + " TEXT NOT NULL) ;";

    public DBhelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
        onCreate(db);
    }
}
