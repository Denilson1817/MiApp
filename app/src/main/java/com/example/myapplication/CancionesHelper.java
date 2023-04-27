package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

public class CancionesHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public  static final String DATABASE_NAME = "Cancionesdb.db";

    public static final String SQL_CREATE_CANCIONES = "CREATE TABLE "+ CancionesContract.CancionTab.TABLE_NAME+
            " (" + BaseColumns._ID + " INTEGER PRIMARY KEY," +
            CancionesContract.CancionTab.COLUMN_TITULO + " TEXT," +
            CancionesContract.CancionTab.COLUMN_CANTANTE + " TEXT)";

    public static final  String SQL_DELETE_CANCIONES = "DROP TABLE IF EXISTS "+
            CancionesContract.CancionTab.TABLE_NAME;

    public CancionesHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_CANCIONES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_CANCIONES);
        onCreate(sqLiteDatabase);
    }
}
